package ge.btu.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.CleartextNetworkViolation
import android.text.TextUtils
import android.view.View
//import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog,null)
        val number = dialogView.findViewById<EditText>(R.id.Number)
        val num : String  = number.text.toString()
        if (TextUtils.isEmpty(num)){
            Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
        }
        builder.setView(dialogView)
        builder.setCancelable(false)
        builder.setTitle("are you sure?")
        builder.setMessage("Do you want to Enter in that App?")
        builder.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int -> })

        builder.setNegativeButton("NO",  { dialogInterface: DialogInterface, i: Int -> })
        builder.show()


    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("are you sure?")
        builder.setMessage("Do you want to close this App?")

        builder.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int -> })


        builder.setNegativeButton("NO",  { dialogInterface: DialogInterface, i: Int -> })
        builder.show()


    }


    fun numberClick(view: View) {
        if (view is TextView) {
            var number: String = view.text.toString()
            var result = resultTextView.text.toString()
            if (result == "0") {
                result = ""
            }
            resultTextView.text = result + number
        }
    }

    fun operationClick(view: View) {
        if (view is TextView) {
            operand = resultTextView.text.toString().toDouble()
            resultTextView.text = ""
            operation = view.text.toString()
        }
    }

    fun equalsClick(view: View) {
        val secOperand: Double = resultTextView.text.toString().toDouble()
        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
        }


    }

}





