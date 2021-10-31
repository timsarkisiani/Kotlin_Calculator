package cdn.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        nuli.setOnClickListener { appendVal("0", false) }
        erti.setOnClickListener { appendVal("1", false) }
        ori.setOnClickListener { appendVal("2", false) }
        sami.setOnClickListener { appendVal("3", false) }
        otxi.setOnClickListener { appendVal("4", false) }
        xuti.setOnClickListener { appendVal("5", false) }
        eqvsi.setOnClickListener { appendVal("6", false) }
        shvidi.setOnClickListener { appendVal("7", false) }
        rva.setOnClickListener { appendVal("8", false) }
        cxra.setOnClickListener { appendVal("9", false) }
        mdzime.setOnClickListener { appendVal(".", false) }
        //Operators
        gasuftaveba.setOnClickListener { appendVal("", true) }
        plusminus.setOnClickListener { appendVal(" ( ", false) }
        gayofa.setOnClickListener { appendVal(" / ", false) }
        gamravleba.setOnClickListener { appendVal(" * ", false) }
        gamokleba.setOnClickListener { appendVal(" - ", false) }
        mimateba.setOnClickListener { appendVal(" + ", false) }

        ukan.setOnClickListener {
            val expression = operacia.text.toString()
            if (expression.isNotEmpty()) {
                operacia.text = expression.substring(0, expression.length - 1)
            }


        }

        tolia.setOnClickListener {
            try {
                val expression = ExpressionBuilder(operacia.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    pasuxi.text = longResult.toString()
                } else
                    pasuxi.text = result.toString()

            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show();

                Log.d("🤔", "Message: ${e.message}")
            }

        }


    }

    fun appendVal(string: String, isClear: Boolean) {
        if (isClear) {
            operacia.text = ""
            pasuxi.text = ""
        } else {
            operacia.append(string)
        }
    }

}
