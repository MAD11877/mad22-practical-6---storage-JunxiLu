package sg.edu.np.mad.junxiprac2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);


        Button groupButton = findViewById(R.id.Group1Btn);
        groupButton.setOnClickListener(view -> {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Group1Fragment Group1box = Group1Fragment.newInstance("Group ", "1");
            ft.replace(R.id.Frame, Group1box);
            ft.commit();

        });
        Button group2Button = findViewById(R.id.Group2Btn);
        group2Button.setOnClickListener(view -> {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Group1Fragment Group2box = Group1Fragment.newInstance("Group ", "1");
            ft.replace(R.id.Frame, Group2box);
            ft.commit();
        });
    }
}