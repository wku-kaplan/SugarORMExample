package sg.com.kaplan.sugarormexample;

import com.orm.SugarRecord;

import java.util.Date;

public class Expense extends SugarRecord<Expense> {
    String item;
    float cost;
    Date date;

    public Expense() {
    }

    public Expense(String item, float cost, Date date) {
        this.item = item;
        this.cost = cost;
        this.date = date;
    }

    public String getItem() {
        return item;
    }

    public float getCost() {
        return cost;
    }

    public Date getDate() {
        return date;
    }
}
