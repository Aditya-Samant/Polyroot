package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class newtonrap extends AppCompatActivity {

    Integer n;
    Integer[] fun= new Integer[30];
    Integer[] diff = new Integer[30];
    String [] sarr=new String[10];
    String [][] data1 = new String[15][2];
    Float neg,pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtonrap);
        newton();
        TableView tableView = findViewById(R.id.table_data_view1);
        String[] headers={"Step NO","X"};
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,headers));
        tableView.setDataAdapter(new SimpleTableDataAdapter(this,data1));
    }

    void newton(){
        Intent intent =getIntent();
        String xz  = intent.getStringExtra("numa");
        n = Integer.valueOf(xz);

        int f1=1,f2=1;
        get_fun();
        System.out.print("\nEnter the negative limit of the function \t");
        while(f1==1)
        {
            String nn  = intent.getStringExtra("bof");
            neg = Float.valueOf(nn);
            if(check(neg)<0){f1=0;}
            else{System.out.print("\n Invalid entry, re-enter!! :\t");}
        }
        System.out.print("\nEnter the positive limit of the function \t");
        while(f2==1)
        {
            String pp = intent.getStringExtra("aof");
            pos = Float.valueOf(pp);
            if(check(pos)>=0){f2=0;}
            else{System.out.print("\n Invalid entry, re-enter!! :\t");}
        }
        System.out.print("\nThe Limit is ("+neg+" , "+pos+")\n");
        solve();
    }
    void solve()
    {
        float mid,x0,x1;
        int t;
        System.out.print("Enter the number for iterations you want to print ( minimum 10) \n");
        t = 15;
        mid=(neg+pos)/2;
        x0=mid;
        for(int i=0;i<t;i++)
        {
            data1 [i][0]=Integer.toString(i+1);
            data1 [i][1]=Float.toString(x0);
            x1=x0-(check(x0)/che_diff(x0));
            x0=x1;
            System.out.print("\nX["+(i+1)+"] :"+mid);
            System.out.print("\nThe New Limit is ("+neg+" , "+pos+")\n");
        }
        System.out.print("\nThe Root is : "+neg);
    }
    void get_fun()
    {
        System.out.print("Enter the highest degree of the polynomial\n");
        Intent intent = getIntent();
        sarr=intent.getStringArrayExtra("arr");
        for(int i=0;i<=n;i++)
        {
            fun[i]=Integer.valueOf(sarr[i]);
        }
        for(int j=1;j<=n;j++)
        {
            diff[j-1]=fun[j]*j;
        }

        System.out.print("Enter the coefficients of the polynomial\n");
    }

    float check(float a)
    {
        float x,ans=0;
        for(int i=0;i<=n;i++)
        {
            x=1;
            for(int j=0;j<i;j++)
            {	x=x*a;}
            ans=ans+(fun[i]*x);
        }
        return ans;
    }
    float che_diff(float a)
    {
        float x,ans=0;
        for(int i=0;i<n;i++)
        {
            x=1;
            for(int j=0;j<i;j++)
            {	x=x*a;}
            ans=ans+(diff[i]*x);
        }
        return ans;
    }

}