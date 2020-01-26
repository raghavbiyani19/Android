import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CustomAdapter extends ArrayAdapter {

    Activity context;
    int amount[];
    int imgs[];


    public CustomAdapter(Context context, int resource,int amount[], int imgs[]) {
        super(context, resource);
        this.amount = amount;
        this.imgs = imgs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        return convertView;
    }

}
/*
Create a DB application for students where you need to create a table having the fields:
1.Roll num
2.Name
3.email
4.semester
Make use of db helper class for creation of db and implement the different methods that are
used to insert,display,update and delete the info.
*/

