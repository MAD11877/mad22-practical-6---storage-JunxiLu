package sg.edu.np.mad.junxiprac2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView desc;
    ImageView picture;
    public UserViewHolder(View viewItem) {
        super(viewItem);
        name = viewItem.findViewById(R.id.username);
        desc = viewItem.findViewById(R.id.desc);
        picture = viewItem.findViewById(R.id.picture);
    }
}
