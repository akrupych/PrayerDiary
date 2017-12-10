package akrupych.prayerdiary

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_day.*
import java.text.SimpleDateFormat
import java.util.*

class DayFragment : Fragment() {

    companion object {

        private const val ARG_DATE = "ARG_DATE"

        fun create(date: Date) = DayFragment().apply {
            arguments = Bundle().apply {
                putLong(ARG_DATE, date.time)
            }
        }
    }

    private lateinit var date: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        date = Date(arguments.getLong(ARG_DATE))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_day, container, false)!!

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        dayText.text = SimpleDateFormat("EEEE", Locale.UK).format(date)
        dateText.text = SimpleDateFormat("dd MMM yyyy", Locale.UK).format(date)
    }
}