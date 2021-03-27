package murguia.jesus.mydigimind.ui.dashboard

import java.io.Serializable

class Carrito :Serializable{
    var recordatorios = ArrayList<Recordatorio>()

    fun agregar(p:Recordatorio):Boolean{
        return recordatorios.add(p)
    }

    fun get():ArrayList<Recordatorio>{
        return recordatorios
    }
}