package com.example.trial1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class Activity2 extends AppCompatActivity {

    Integer n;
    Integer[] fun= new Integer[30];
    String [] sarr=new String[10];
    String [][] data1 = new String[15][4];
    Float neg,pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        bisec();
        TableView tableView = findViewById(R.id.table_data_view);
        String[] headers={"Step NO","X","(a","b)"};
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,headers));
        tableView.setDataAdapter(new SimpleTableDataAdapter(this,data1));
    }

  void bisec(){
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
            float mid;
            int t;
            System.out.print("Enter the number for iterations you want to print ( minimum 10) \n");
            t = 15;
            for(int i=0;i<t;i++)
            {
                mid=(neg+pos)/2;
                if(check(mid)<0){neg=mid;}
                else{pos=mid;}
                data1 [i][0]=Integer.toString(i+1);
                data1 [i][1]=Float.toString(mid);
                data1 [i][2]=Float.toString(neg);
                data1 [i][3]=Float.toString(pos);
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
    }





