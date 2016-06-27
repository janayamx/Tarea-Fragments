package com.jorgearreola.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentDetalle extends Fragment {



    private String info[]=new String[]{"","",""};

    private Integer[] imgid={
            R.drawable.user,
            R.drawable.twitter,
            R.drawable.phone,
    };

    private ListView lista;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }


    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);


		/*LenguajeListAdapter adapter=new LenguajeListAdapter(this, lenguajeProgramacion ,imgid);
		lista = (ListView)getView().findViewById(R.id.DtListado);
		lista.setAdapter(adapter);
*/
    }

    public class LenguajeListAdapter extends ArrayAdapter<String> {


        private final Activity context;
        private final String[] itemname;
        private final Integer[] integers;


        LenguajeListAdapter(Fragment context, String[] itemname, Integer[] integers) {
            super(context.getActivity(), R.layout.listitem_detalle, itemname);
            this.context = context.getActivity();
            this.itemname=itemname;
            this.integers=integers;
        }



        public View getView(int posicion, View view, ViewGroup parent){

            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.listitem_detalle,null,true);

            TextView txtTitle = (TextView) rowView.findViewById(R.id.texto_principal);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


            txtTitle.setText(itemname[posicion]);
            imageView.setImageResource(integers[posicion]);


            return rowView;
        }



    }


    public void mostrarNombre(String texto) {

        info[0] = texto;

        LenguajeListAdapter adapter=new LenguajeListAdapter(this, info ,imgid);
        lista = (ListView)getView().findViewById(R.id.DtListado);
        lista.setAdapter(adapter);

    }

    public void mostrarTwitter(String texto) {

        info[1] = texto;
    }

    public void mostrarTelefono(String texto) {

        info[2] = texto;
    }


}
