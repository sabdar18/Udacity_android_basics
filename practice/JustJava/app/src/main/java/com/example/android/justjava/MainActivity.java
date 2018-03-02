/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * variables quantity and price created and initialized
     */
    private int quantity = 0;
    private int cost = 5;
    private TextView orderSummaryTextView;
    private CheckBox whippedCreamCheckBox;
    private CheckBox chocolateCheckBox;
    private boolean hasWhippedCream = false;
    private boolean hasChocolate = false;
    private TextView quantityTextView;
    private EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
//        orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        whippedCreamCheckBox = findViewById(R.id.whipped_cream_check_box);
        chocolateCheckBox = findViewById(R.id.chocolate_check_box);
        userName = findViewById(R.id.user_name);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        quantityTextView.setText(String.valueOf(number));
    }

    /**
     * This method to increase Quantity
     *
     * @param view
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method to decrease quantity
     */
    public void decrement(View view) {
        if (quantity == 0)
            return;
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        orderSummaryTextView.setText(message);
//    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String message = createOrderSummary(price);
//        displayMessage(message);
        sendMessage(message);
    }

    /**
     * Send Order Summary  in Email
     * @param message
     */
    private void sendMessage(String message) {
        String[] addresses =  new String[]{"hello@gmail.com","test@gmail.com"};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this, R.string.no_app_error, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Calculates the price of the order.
     * @return total price
     */
    private int calculatePrice() {
        int price  = cost;
        if(hasWhippedCream){
            price +=1;
        }
        if(hasChocolate){
            price +=2;
        }
        return quantity * price;
    }

    /**
     * Create Order Summary
     * @param price of the order
     * @return summary
     */
    private String createOrderSummary(int price) {
        String message = getString(R.string.order_name) + userName.getText().toString();
        message += getString(R.string.order_whipped_cream) + hasWhippedCream;
        message += getString(R.string.order_chocolate) + hasChocolate;
        message += getString(R.string.order_quantity) + quantity;
        message += getString(R.string.order_total) + price;
        message += getString(R.string.order_thank);
        return message;
    }

    /**
     * To check Whipped Cream CheckBox and Chocolate CheckBox
     * and update the values of haswWhippedCream, hasChocolate
     * @param view
     */

    public void onCheckBoxClicked(View view) {
        int checkBoxId = view.getId();
        switch (checkBoxId) {
            case R.id.whipped_cream_check_box:
                hasWhippedCream = whippedCreamCheckBox.isChecked();
                break;
            case R.id.chocolate_check_box:
                hasChocolate = chocolateCheckBox.isChecked();
                break;
            default:
                break;
        }
    }

}