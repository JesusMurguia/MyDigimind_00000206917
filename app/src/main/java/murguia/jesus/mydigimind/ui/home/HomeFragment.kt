package murguia.jesus.mydigimind.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import murguia.jesus.mydigimind.R
import murguia.jesus.mydigimind.ui.dashboard.Carrito
import murguia.jesus.mydigimind.ui.dashboard.Recordatorio
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.recordatorio.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
       // val textView: TextView = root.findViewById(R.id.text_home)
        //homeViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        //})



        return root
    }

    private lateinit var carrito:Carrito
    override fun onStart() {
        super.onStart()
        Toast.makeText(context, "cocaina", Toast.LENGTH_LONG).show()
        carrito= Carrito()
        carrito.agregar(Recordatorio("Monday","3:33","comer 2 aguacates"))
        carrito.agregar(Recordatorio("Tuesday","3:33","comer 1 aguacate"))
        carrito.agregar(Recordatorio("Wednesday","3:33","salir a pasiar"))
        carrito.agregar(Recordatorio("Thursday","3:33","sembrar papas"))
        carrito.agregar(Recordatorio("Friday","3:32","cocechar papas"))



        gridview.adapter=RecordatorioAdapter(requireContext(),carrito.get())
    }


    class RecordatorioAdapter: BaseAdapter{
        var recordatorios= ArrayList<Recordatorio>()
        var contexto: Context? =null
        constructor(contexto: Context, recordatorios: ArrayList<Recordatorio>){
            this.contexto=contexto
            this.recordatorios=recordatorios
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var recordatorio=recordatorios[p0]
            var inflador=contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista=inflador.inflate(R.layout.recordatorio, null)
            vista.txtNombreRecordatorio.setText(recordatorio.nombre)
            vista.txtDiasRecordatorio.setText(recordatorio.dias)
            vista.txtTiempoRecordatorio.setText(recordatorio.tiempo)
            return vista
        }

        override fun getItem(p0: Int): Any {
            return recordatorios[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return recordatorios.size
        }
    }


}

