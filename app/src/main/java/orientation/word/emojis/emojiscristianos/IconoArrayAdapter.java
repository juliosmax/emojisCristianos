package orientation.word.emojis.emojiscristianos;

import android.app.Activity;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by julio on 23/02/18.
 */

public class IconoArrayAdapter extends ArrayAdapter<Icono> {

    public IconoArrayAdapter(Activity context, ArrayList<Icono> iconoList)
    {
        super(context, 0, iconoList);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItemView = convertView;
        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_icon, parent, false);
        }

        Icono currentIconItem = getItem(position);

        ImageView img=listItemView.findViewById(R.id.id_img);
        img.setImageResource(currentIconItem.getImageId());
        return listItemView;
    }
}
