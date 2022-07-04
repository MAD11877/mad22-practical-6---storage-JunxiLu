package sg.edu.np.mad.junxiprac2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        FirebaseDatabase db = FirebaseDatabase.getInstance("https://practical6-f6f06-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference UserRef = db.getReference("Users");
        EditText username = findViewById(R.id.login_username);
        EditText pass = findViewById(R.id.login_pass);
        Button loginBtn = findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserRef.child("mad").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String firebasePass = snapshot.child("password").getValue(String.class);
                        String firebaseName = snapshot.child("username").getValue(String.class);

                        String name = username.getText().toString();
                        String password = pass.getText().toString();

                        if (firebaseName.equals(name) && firebasePass.equals(password)) {
                            Intent list = new Intent(login_page.this, ListActivity.class);
                            startActivity(list);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
    }
});
    }}