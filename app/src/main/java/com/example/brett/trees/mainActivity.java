package com.example.brett.trees;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.TreeSet;

public class mainActivity extends Activity
{
    private Boolean flag = false;
    private TreeSet<String> myTree = new TreeSet<String>();
//    *************MENU STUFF**************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//  ****************END***********MENU STUFF*******************

//  ****************CLASS FUNCTIONS***************************
    public void addUserInput(View v)
    {
        EditText valueET = (EditText) findViewById(R.id.editText1);
        if(myTree.contains(valueET.getText().toString()))
            duplicateValueAttempt();
        else
        {
            this.myTree.add(valueET.getText().toString());
            TextView tv = (TextView) findViewById(R.id.textView1);
            tv.setText(printTree());
        }
    }

    public void duplicateValueAttempt()
    {
        // change text box
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(getString(R.string.duplicate_key_message));
        // clear user inputs
        EditText et1 = (EditText) findViewById(R.id.editText1);
        et1.setText("");
    }
    public void clearTree(View v)
    {
        // clear the map
        this.myTree.clear();
        // change text box
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(getString(R.string.textView1));
    }
    public String printTree()
    {
        String text ="";
        if(!this.myTree.isEmpty())
        {
            for (Iterator i = this.myTree.iterator(); i.hasNext();)
            {
                String newline =  "Value: [" + (String) i.next() + "]\n";
                text += newline;
            }
        }
        else
        {
            text = "the Tree is empty";
        }
        return text;
    }
}
