package com.example.vault.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.vault.R
import com.example.vault.adapter.LoginAdapter
import com.example.vault.database.CardDatabase
import com.example.vault.database.LoginDatabase
import com.example.vault.model.Card
import com.example.vault.repository.Repository
import com.example.vault.viewmodel.DetailsViewModel
import com.example.vault.viewmodel.DetailsViewModelFactory
import kotlinx.android.synthetic.main.fragment_add_card.*
import java.text.SimpleDateFormat
import java.util.*

class AddCardFragment : Fragment() {
    private val cardList = arrayListOf("Debit","Credit","Forex","Prepaid","Others")
    private lateinit var vm: DetailsViewModel
    private lateinit var rp: Repository
    private lateinit var cardDatabase: CardDatabase
    private lateinit var loginDatabase: LoginDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTextWatcher()
        initSpinner()
        addDebitCard.setOnClickListener {
            val cardNumber = cardNumberEt.text.toString().trim()
            val cardHolder = cardHolderEt.text.toString().trim()
            val cardCVV    = cardCvvEt.text.toString().trim()
            val cardExpiry = cardExpiryEt.text.toString().trim()
            cardDatabase = CardDatabase.getDatabase(requireContext())
            loginDatabase = LoginDatabase.getDatabase(requireContext())
            rp = Repository(cardDatabase, loginDatabase)
            vm = ViewModelProvider(this, DetailsViewModelFactory(rp)).get(DetailsViewModel::class.java)



            if(valid(cardNumber,cardHolder,cardExpiry,cardCVV)){
                var split : Array<String> = cardExpiry.split("/").toTypedArray()
                val selected=cardSpinner.selectedItem.toString()
                val sdf=SimpleDateFormat("MM/dd/yyy")
                val currentd=sdf.format(Date())
                vm.insertcard(Card(cardHolder,cardNumber,split[0],split[1],cardCVV,selected.uppercase(),cardNameEt.text.toString(),currentd ))
                Toast.makeText(requireContext(),"Card Details Saved ",Toast.LENGTH_LONG).show()
                val action=AddCardFragmentDirections.actionAddCardFragmentToCardFragment()
                findNavController().navigate(action)
            }
            else
                Toast.makeText(context,"Please fil all blanks",Toast.LENGTH_SHORT).show()
        }
    }
    private fun setUpTextWatcher() {
      cardNumberEt.addTextChangedListener(object :TextWatcher {
          private val TOTAL_SYMBOLS = 19 // size of pattern 0000-0000-0000-0000
          private val TOTAL_DIGITS = 16 // max numbers of digits in pattern: 0000 x 4
          private val DIVIDER_MODULO = 5 // means divider position is every 5th symbol beginning with 1
          private val DIVIDER_POSITION = DIVIDER_MODULO - 1 // means divider position is every 4th symbol beginning with 0
          private val DIVIDER = '-'
          override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

          }

          override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

          }

          override fun afterTextChanged(p0: Editable) {
              if (!isInputCorrect(p0, TOTAL_SYMBOLS, DIVIDER_MODULO, DIVIDER)) {
                  val repl = buildCorrectString(
                      getDigitArray(p0, TOTAL_DIGITS),
                      DIVIDER_POSITION,
                      DIVIDER
                  )
              cardNumberEt.clearFocus()
              cardNumberEt.setText(repl)
              cardNumberEt.requestFocus()
              cardNumberEt.setSelection(repl!!.length)

          }
      }
          private fun isInputCorrect(s: Editable, totalSymbols: Int, dividerModulo: Int, divider: Char): Boolean {
              var isCorrect = s.length <= totalSymbols
              for (i in s.indices) {
                  isCorrect = if (i > 0 && (i + 1) % dividerModulo == 0) {
                      isCorrect and (divider == s[i])
                  } else {
                      isCorrect and Character.isDigit(s[i])
                  }
              }
              return isCorrect
          }

          private fun buildCorrectString(digits: CharArray, dividerPosition: Int, divider: Char): String? {
              val formatted = StringBuilder()
              for (i in digits.indices) {
                  if (digits[i] != '\u0000') {
                      formatted.append(digits[i])
                      if (i > 0 && i < digits.size - 1 && (i + 1) % dividerPosition == 0) {
                          formatted.append(divider)
                      }
                  }
              }
              return formatted.toString()
          }

          private fun getDigitArray(s: Editable, size: Int): CharArray {
              val digits = CharArray(size)
              var index = 0
              var i = 0
              while (i < s.length && index < size) {
                  val current = s[i]
                  if (Character.isDigit(current)) {
                      digits[index] = current
                      index++
                  }
                  i++
              }
              return digits
          }

      })
      cardExpiryEt.addTextChangedListener(object : TextWatcher{
            var first = 0

            override fun afterTextChanged(text: Editable) {
                val second = first;
                first = text.length



                if(cardExpiryEt.text.length==2 && first>second){
                    cardExpiryEt.append("/");
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(sequence: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

    }
    private fun initSpinner() {
        val adapter = ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, cardList)
        cardList.sort()
        cardSpinner.adapter = adapter

    }
    private fun valid(cardNumber : String, cardHolder : String,  cardExpiry: String, cardCVV: String) : Boolean{
        val list = cardExpiry.split("/")

        return !(cardNumber.isEmpty() || cardHolder.isEmpty() || cardCVV.isEmpty() || cardNameEt.text.isEmpty()
                || cardExpiry.isEmpty() || cardSpinner.isEmpty() || list[0].toInt() > 12)
    }



}
