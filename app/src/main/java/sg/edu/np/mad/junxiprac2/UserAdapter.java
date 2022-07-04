package sg.edu.np.mad.junxiprac2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    ArrayList<user> data;
    Context context;
    ListActivity activity;

    public UserAdapter(ArrayList<user> data, Context context) {
        this.data =  data;
        this.context =  context;
        this.activity =  activity;
    }



    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == 0) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_seven, null, false);
        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, null, false);
        }
        return new UserViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        user user = data.get(position);
        return (user.name.substring(user.name.length() - 1).equals("7")) ? 0 : 1;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        user user = data.get(position);
        holder.name.setText(user.name);
        holder.desc.setText(user.description);

        holder.picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Profile");
                builder.setMessage(holder.name.getText());
                builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(view.getContext(), MainActivity.class);

                        intent.putExtra("name", user.name);
                        intent.putExtra("description", user.description);
                        intent.putExtra("number", holder.getAdapterPosition());
                        intent.putExtra("follow", user.followed);
                        view.getContext().startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
