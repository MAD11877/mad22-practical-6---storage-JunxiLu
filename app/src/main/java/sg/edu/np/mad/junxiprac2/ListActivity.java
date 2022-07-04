package sg.edu.np.mad.junxiprac2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import android.widget.Adapter;



import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        /*
        Random random = new Random();

        ArrayList<user> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String name = "Name" + Long.toString(random.nextLong());
            String desc = "Description" + Long.toString(random.nextLong());
            Boolean follow = random.nextBoolean();

            user user = new user(name,desc,i,follow);
            userList.add(user);
        }

         */

        SQLAdapter db = new SQLAdapter(this);


        ArrayList<user> data = db.getUsers();
        if(data.size()==0) {
            for (int a = 0; a < 20; a++) {
                Random random = new Random();

                user NewUser = new user("Name"+Long.toString(random.nextLong()),
                "Description"+Long.toString(random.nextLong()), a,false);
                data.add(NewUser);
            }
            for(int b = 0; b < data.size(); b++) {
                db.addUser(data.get(b));
            }
        }



        RecyclerView rv = findViewById(R.id.rv);
        UserAdapter UserAdapter = new UserAdapter(data, ListActivity.this);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setAdapter(UserAdapter);

    }
}