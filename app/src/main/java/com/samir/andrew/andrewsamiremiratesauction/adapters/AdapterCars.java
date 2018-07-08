package com.samir.andrew.andrewsamiremiratesauction.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joooonho.SelectableRoundedImageView;
import com.samir.andrew.andrewsamiremiratesauction.R;
import com.samir.andrew.andrewsamiremiratesauction.customViews.CustomItem;
import com.samir.andrew.andrewsamiremiratesauction.models.ModelCarsOnline.Cars;
import com.samir.andrew.andrewsamiremiratesauction.utlities.SharedPrefHelper;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class AdapterCars extends RecyclerView.Adapter<AdapterCars.MyViewHolder> {

    private List<Cars> adapterList;
    private Activity activity;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvRvCarItemTitle, tvRvCarItemPrice, tvRvCarItemCurrency;
        ImageView imgRvCarItemFav;
        SelectableRoundedImageView imgRvCarItemCarImg;
        CustomItem cuiRvCarItemLot, cuiRvCarItemBids, cuiRvCarItemTimeLeft;

        MyViewHolder(View view) {
            super(view);

            imgRvCarItemCarImg = view.findViewById(R.id.imgRvCarItemCarImg);
            imgRvCarItemFav = view.findViewById(R.id.imgRvCarItemFav);
            tvRvCarItemTitle = view.findViewById(R.id.tvRvCarItemTitle);
            tvRvCarItemPrice = view.findViewById(R.id.tvRvCarItemPrice);
            tvRvCarItemCurrency = view.findViewById(R.id.tvRvCarItemCurrency);
            cuiRvCarItemLot = view.findViewById(R.id.cuiRvCarItemLot);
            cuiRvCarItemBids = view.findViewById(R.id.cuiRvCarItemBids);
            cuiRvCarItemTimeLeft = view.findViewById(R.id.cuiRvCarItemTimeLeft);

        }
    }

    public AdapterCars(List<Cars> adapterList, Activity activity) {
        this.adapterList = adapterList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_car_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Cars car = adapterList.get(position);

        float twoDp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2,
                activity.getResources().getDisplayMetrics());

        if (SharedPrefHelper.getInstance(activity).getLang().equals("en")) {
            holder.tvRvCarItemTitle.setText(car.getMakeen() + " " + car.getModelen() + " " + car.getYear());
            holder.tvRvCarItemCurrency.setText(car.getAuctioninfo().getCurrencyen());
            holder.imgRvCarItemCarImg.setCornerRadiiDP(twoDp, 0, twoDp, 0);

        } else {
            holder.tvRvCarItemTitle.setText(car.getMakear() + " " + car.getModelar() + " " + car.getYear());
            holder.tvRvCarItemCurrency.setText(car.getAuctioninfo().getCurrencyar());
            holder.imgRvCarItemCarImg.setCornerRadiiDP(0, twoDp, 0, twoDp);
        }
        holder.cuiRvCarItemLot.setValue(car.getAuctioninfo().getLot() + "");
        holder.cuiRvCarItemBids.setValue(car.getAuctioninfo().getBids() + "");

        holder.tvRvCarItemPrice.setText(getFormattedForMap(car.getAuctioninfo().getCurrentprice()));

        String newImage = car.getImage().replaceAll("\\[w]", "0").replaceAll("\\[h]", "0");
        Picasso.with(activity)
                .load(newImage)
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imgRvCarItemCarImg);

        Long currentMillis = System.currentTimeMillis() / 1000;

        // save end time for every item to make sure it will be always correct after scrolling
        if (car.getAuctioninfo().getFinishTimeInMillis() == null) {
            Long timeDifference = (long) (car.getAuctioninfo().getEnddate());
            Long finishTime = currentMillis + timeDifference;
            car.getAuctioninfo().setFinishTimeInMillis(finishTime);
        }
        Long time = car.getAuctioninfo().getFinishTimeInMillis() - currentMillis;
        holder.cuiRvCarItemTimeLeft.setTimer(time * 1000, (long) 1);
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }

    //region helper methods

    public void addItem(Cars item) {
        insertItem(item, adapterList.size());
        notifyDataSetChanged();
    }

    public void insertItem(Cars item, int position) {
        adapterList.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        adapterList.remove(position);
        notifyItemRemoved(position);
    }

    public void clearAllListData() {
        int size = adapterList.size();
        adapterList.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void addAll(List<Cars> items) {
        adapterList.clear();
        adapterList.addAll(items);
        notifyDataSetChanged();
    }

    public List<Cars> getAllData() {
        return adapterList;
    }

    private String getFormattedForMap(int price) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###,###");

        String formattedString = formatter.format(price);

        return formattedString;

    }

    //endregion
}

