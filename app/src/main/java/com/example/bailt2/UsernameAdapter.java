package com.example.bailt2;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsernameAdapter extends RecyclerView.Adapter<UserViewHolder> {
    Context context;
    ArrayList<Model_User> listUser;
    Fragment_User fragment_user;

    public UsernameAdapter(Context context, ArrayList<Model_User> listUser, Fragment_User fragment_user) {
        this.context = context;
        this.listUser = listUser;
        this.fragment_user = fragment_user;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(context);
        View view_of_item = inflater.inflate(R.layout.custom_item_layout,parent,false);
        UserViewHolder userViewHolder =  new UserViewHolder(view_of_item);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        Model_User user = listUser.get(position);
        holder.ID.setText(user.ID + ""  );
        holder.Username.setText(user.username);
        holder.Phone.setText(user.phone + "");
        holder.Password.setText(user.password);
        holder.Fullname.setText(user.fullname);
        holder.Birth.setText(user.birth +"");
        holder.ID_Group.setText(user.ID_group +"");
//        holder.Btn_Xoa

        holder.Btn_Xoa.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder (context);
                builder.setTitle ("Delte ");
                builder.setMessage ("bạn có chắc chắn muốn xóa không");
                builder.setPositiveButton ("Yes", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fragment_user.Xoa(user.getID());
                    }
                });
                builder.setNegativeButton ("No", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss ();
                    }
                });
                builder.create ().show ();
            }
        });
    }



    @Override
    public int getItemCount() {
        return listUser.size();
    }
}
