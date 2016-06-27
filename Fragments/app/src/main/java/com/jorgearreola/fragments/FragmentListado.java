package com.jorgearreola.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentListado extends Fragment {

    private Amigo[] datos =
            new Amigo[]{
                    new Amigo("Juan", "@juanmx", "5534789000"),
                    new Amigo("Mario", "@Mariomx", "5567843200"),
                    new Amigo("Ernesto", "@Ernestomx", "5563359878"),
                    new Amigo("Sofia", "@Sofiamx", "5563352876"),
                    new Amigo("Alejandro", "@alejandromx", "5523399878")};

    private ListView lstListado;

    private AmigosListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        lstListado = (ListView)getView().findViewById(R.id.LstListado);

        lstListado.setAdapter(new AdaptadorAmigos(this));

        lstListado.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
                if (listener!=null) {
                    listener.onAmigoSeleccionado(
                            (Amigo)lstListado.getAdapter().getItem(pos));
                }
            }
        });
    }

    class AdaptadorAmigos extends ArrayAdapter<Amigo> {

        Activity context;

        AdaptadorAmigos(Fragment context) {
            super(context.getActivity(), R.layout.listitem_amigo, datos);
            this.context = context.getActivity();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_amigo, null);

            TextView lblNombre = (TextView)item.findViewById(R.id.LblNombre);
            lblNombre.setText(datos[position].getNombre());

           return(item);
        }
    }

    public interface AmigosListener {
        void onAmigoSeleccionado(Amigo c);
    }

    public void setAmigosListener(AmigosListener listener) {
        this.listener=listener;
    }
}
