package com.example.planets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItemPlanetsAdapterActivity extends BaseAdapter {

    Context context;
    ListData[] items;

    public ListItemPlanetsAdapterActivity(Context context) {
        this.context = context;
        this.items = addItemsToList();
    }

    private ListData[] addItemsToList(){
        ListData[] data = new ListData[5];
        data[0] = new ListData("Mercurio", "O diâmetro de Mercúrio é de 4.880 km. É considerado um Planeta de órbita excêntrica porque a distância em relação ao Sol muda conforme a posição na órbita e isto é responsável pela variação de temperatura do planeta, de 180 °C a 400 °C.", R.drawable.mercurio, "0 Luas");
        data[1] = new ListData("Venus", "Vênus tem 12.104 km de diâmetro, ou seja, seu raio equivale a 6.052 km. A sua superfície é coberta de lava e composta principalmente de dióxido de carbono e ácido sulfúrico, os quais formam nuvens densas responsáveis pelo fenômeno de efeito estufa.", R.drawable.venus, "0 Luas");
        data[2] = new ListData("Terra", "O planeta Terra é um dos quatro planetas rochosos que compõem o Sistema Solar, localizado na Via Láctea.", R.drawable.terra, "1 Luas");
        data[3] = new ListData("Marte", "Marte é um planeta muito frio, árido e rochoso. A sua temperatura máxima é de aproximadamente 25°C, com uma média de -60°C, a qual pode chegar até cerca de -140°C durante a noite. Sendo um planeta terrestre (rochoso), suas camadas são compostas por atmosfera, crosta, manto e núcleo.", R.drawable.marte, "2 Luas");
        data[4] = new ListData("Jupter", "Júpiter é um gigante gasoso e o maior planeta do Sistema Solar. Júpiter é o quinto planeta do Sistema Solar a partir do Sol. Trata-se de um gigante gasoso que apresenta superfície formada pelos gases hélio e hidrogênio, em sua maioria, com uma ampla atmosfera e um núcleo sólido ou pastoso em seu interior.", R.drawable.jupter, "79 Luas");

        return data;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list_item_planets_custom_adapter, parent, false);

            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.imageViewItem);
            holder.title = convertView.findViewById(R.id.textTitleItem);
            holder.description = convertView.findViewById(R.id.textDescriptionItem);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img.setBackgroundResource(items[position].img);
        holder.title.setText(items[position].title);
        holder.description.setText(items[position].luas);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsPlanetsActivity.class);
                intent.putExtra("planeta_nome", items[position].title);
                intent.putExtra("planeta_descricao", items[position].description);
                intent.putExtra("planeta_imagem", items[position].img);
                context.startActivity(intent);

            }
        });

        return convertView;
    }

    static class ViewHolder{
        ImageView img;
        TextView title;
        TextView description;
    }

    public class ListData {
        String title, description, luas;
        int img;

        public ListData(String title, String description, int img, String luas) {
            this.title = title;
            this.description = description;
            this.luas = luas;
            this.img = img;
        }
    }
}