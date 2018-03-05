package com.kalenicz.maciej.retrofi2test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIInterface apiInterface;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    Context context;
    EditText name;
    EditText lastName;
    EditText number;
    Button okButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.new_name);
        lastName = findViewById(R.id.new_last_name);
        number = findViewById(R.id.new_number);
        okButton = findViewById(R.id.ok_button);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserName();
            }
        });
        apiInterface = APIClient.getClient().create(APIInterface.class);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(context);

        getListUsers(recyclerView);
    }

    private void updateUserName() {
        User user = new User(name.getText().toString(), lastName.getText().toString());
        String numberOfUser = number.getText().toString();
        if (numberOfUser.equals("")) {
            numberOfUser = "0";
        }
        Call<User> call = apiInterface.updateUserInfo(numberOfUser, user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(
                    final Call<User> call,
                    final Response<User> response) {
                Toast.makeText(getApplicationContext(), "Zaktualizowano użytkownika" + ": \n" + user.getFirst_name() + " " + user.getLast_name(), Toast.LENGTH_SHORT).show();
                getListUsers(recyclerView);
            }

            @Override
            public void onFailure(
                    final Call<User> call,
                    final Throwable t) {
            }
        });
    }

    private void getListUsers(RecyclerView recyclerView) {
        Call<UserList> call2 = apiInterface.doGetUserList();
        call2.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                UserList userList = response.body();
                List<UserList.Datum> datumList = userList.getData();
                for (UserList.Datum datum : datumList) {
                    Adapter adapter = new Adapter(datumList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
