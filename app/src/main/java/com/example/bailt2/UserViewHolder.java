package com.example.bailt2;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView ID,Username,Password,Phone,Birth,ID_Group,Fullname;
    public Button Btn_Sua,Btn_Xoa;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        ID = itemView.findViewById(R.id.tv_id);
        Username = itemView.findViewById(R.id.tv_username);
        Password = itemView.findViewById(R.id.tv_password);
        Phone = itemView.findViewById(R.id.tv_phone);
        Birth = itemView.findViewById(R.id.tv_birth);
        ID_Group = itemView.findViewById(R.id.tv_id_group);
        Fullname = itemView.findViewById(R.id.tv_fullname);
        Btn_Sua = itemView.findViewById(R.id.btn_sua);
        Btn_Xoa = itemView.findViewById(R.id.btn_xoa);
    }
}
