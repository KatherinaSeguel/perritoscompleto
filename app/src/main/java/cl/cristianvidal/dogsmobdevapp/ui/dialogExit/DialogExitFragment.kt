package cl.cristianvidal.dogsmobdevapp.ui.dialogExit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import cl.cristianvidal.dogsmobdevapp.R

class DialogExitFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_dialog_exit, container, false)

        return root
    }
}