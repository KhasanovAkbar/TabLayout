package pdp.uz.payme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_image.view.*
import pdp.uz.payme.models.Data


private const val ARG_PARAM1 = "param1"

class ImageFragment : Fragment() {

    private var param1: Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as Data

        }
    }

    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_image, container, false)
        root.image_view.setImageResource(param1!!.img)
        root.title_tv.text = param1!!.title
        root.info_tv.text = param1!!.info
        return root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: Data) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}