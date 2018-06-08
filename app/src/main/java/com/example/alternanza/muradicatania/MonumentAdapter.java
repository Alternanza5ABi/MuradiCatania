package com.example.alternanza.muradicatania;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonumentAdapter extends RecyclerView.Adapter<MonumentAdapter.ViewHolder>
{
    private Context mContext;
    private List<Monument> monumentList;

    public MonumentAdapter(Context mContext, List<Monument> monumentList)
    {
        this.mContext = mContext;
        this.monumentList = monumentList;
    }

    @NonNull
    @Override
    public MonumentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater= LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.card_view_monument, null);
        return new ViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull MonumentAdapter.ViewHolder holder, int position)
    {

        Monument monument= monumentList.get(position);
        holder.iv_monument.setImageDrawable( mContext.getResources().getDrawable( monument.getImmagine() ) );

        holder.tv_name.setText( monument.getNome() );

        holder.tv_description.setMaxLines(4);
        holder.tv_description.setEllipsize(TextUtils.TruncateAt.END);
        holder.tv_description.setText(monument.getDescrizione());

    }

    @Override
    public int getItemCount()
    {
        return monumentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iv_monument;
        TextView tv_name;
        TextView tv_description;
        TextView tv_read_more;
        TextView b_go_monument;
        Context vh_context;
        Boolean truncate = true;

        public ViewHolder(View itemView, Context context)
        {
            super(itemView);
            iv_monument= itemView.findViewById(R.id.iv_monument);
            tv_name= itemView.findViewById(R.id.tv_name);
            tv_description= itemView.findViewById(R.id.tv_desc);
            tv_read_more= itemView.findViewById(R.id.tv_read_more);
            b_go_monument= itemView.findViewById(R.id.b_go_monument);

            vh_context= context;

            tv_read_more.setOnClickListener(myOnClickListener);
            b_go_monument.setOnClickListener(myOnClickListener);
        }

        private View.OnClickListener myOnClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch ( v.getId() )
                {
                    case R.id.b_go_monument:

                        Double latd = Double.parseDouble(monumentList.get( getAdapterPosition() ).getLatitudine()) ;
                        Double longd = Double.parseDouble(monumentList.get( getAdapterPosition() ).getLongitudine()) ;

                        String nome = monumentList.get(getAdapterPosition()).getNome();
                        Intent intent = new Intent(mContext, MapsActivity.class);
                        intent.putExtra("long", longd);
                        intent.putExtra("lat", latd);
                        intent.putExtra("nome", nome);
                        mContext.startActivity(intent);

                    break;

                    case R.id.tv_read_more:

                        if(truncate)
                        {
                            tv_description.setEllipsize(null);
                            tv_description.setMaxLines(Integer.MAX_VALUE);
                            tv_description.setText( monumentList.get( getAdapterPosition() ).getDescrizione() );
                            tv_read_more.setText(vh_context.getResources().getString(R.string.cw_hide_read_more));
                            truncate = false;
                        }
                        else
                        {
                            tv_description.setMaxLines(4);
                            tv_description.setEllipsize(TextUtils.TruncateAt.END);
                            tv_description.setText( monumentList.get( getAdapterPosition() ).getDescrizione() );
                            tv_read_more.setText(vh_context.getResources().getString(R.string.cw_read_more));
                            truncate = true;
                        }

                    break;
                }
            }
        };
    }
}
