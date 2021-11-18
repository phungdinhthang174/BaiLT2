package com.example.bailt2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bailt2.DAO.DAO_User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Fragment_User extends Fragment {
    RecyclerView recyclerView;
    UsernameAdapter usernameAdapter;
    DAO_User dao_user;
    ArrayList<Model_User> arrayList;
    FloatingActionButton floatingActionButton;
    Button Btn_Xoa;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao_user = new DAO_User(getActivity());
    }

    public Fragment_User() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return   inflater.inflate(R.layout.fragment_user,container,false);


//
//        Model_User user =  new Model_User(101,"thangpd","pdt174","Phùng Đình Thắng",235644525,"28/05/2002",100);
//        ArrayList<Model_User> list  = new ArrayList<Model_User>();
//        list.add(user);
//        Model_User user2 = new Model_User(102,"ath","475kp","Anh Thế Hoàng",0312045066,"14/11/2002",100);
//        list.add(user2);
//         Model_User user3 = new Model_User(103,"dta","dta123","Đào Thế Anh",962318760,"10/10/2002",200);
//         list.add(user3);
//
////        usernameAdapter = new UsernameAdapter(view.getContext(),list, this);
////        recyclerView.setAdapter(usernameAdapter);
//        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle_view_user);
        floatingActionButton = view.findViewById(R.id.floating_btn_add);
        Btn_Xoa = view.findViewById(R.id.btn_xoa);
        recyclerView.hasFixedSize();
        arrayList = new ArrayList<>();
        usernameAdapter = new UsernameAdapter(getActivity(),arrayList,this);
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(usernameAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogThemUser();
            }
        });


    }



    private void DialogThemUser(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view =LayoutInflater.from(getActivity()).inflate(R.layout.dialog_add_user,null);
        builder.setView(view);
        TextInputEditText ID = view.findViewById(R.id.ed_id);
        TextInputEditText Username = view.findViewById(R.id.ed_username);
        TextInputEditText Password = view.findViewById(R.id.ed_pass);
        TextInputEditText Fullname = view.findViewById(R.id.ed_fullname);
        TextInputEditText Phone = view.findViewById(R.id.ed_phone);
        TextInputEditText Birth = view.findViewById(R.id.ed_birth);
        TextInputEditText ID_Group = view.findViewById(R.id.ed_id_group);
        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int id = Integer.parseInt(ID.getText().toString());
                String username = Username.getText().toString();
                String pass = Password.getText().toString();
                String fullname = Fullname.getText().toString();
                int phone = Integer.parseInt(Phone.getText().toString());
                String birth = Birth.getText().toString();
                int id_group = Integer.parseInt(ID_Group.getText().toString());
                Model_User user = new Model_User(id,username,pass,fullname,phone,birth,id_group);
                arrayList.add(user);
                usernameAdapter.notifyDataSetChanged();
                dao_user.them_user(user);
                Toast.makeText(getActivity(),"Bạn đã thêm thành công",Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        builder.create().show();
    }

    public void Xoa(int id){
        dao_user.Delete(id);
        Resume();
    }
    public void Resume(){
        arrayList.clear();
        arrayList.addAll(dao_user.userList());
//        usernameAdapter.notifyDataSetChanged();
        if(usernameAdapter != null){
            usernameAdapter.notifyDataSetChanged ();

        }
    }
}
