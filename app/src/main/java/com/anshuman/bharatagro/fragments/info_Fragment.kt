package com.anshuman.bharatagro.fragments
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anshuman.bharatagro.Activitys.Deatils_InfoActivity
import com.anshuman.bharatagro.Adapters.InfoAdapter
import com.anshuman.bharatagro.Model.RetrieveData
import com.anshuman.bharatagro.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
class info_Fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: InfoAdapter
    private lateinit var dataList: ArrayList<RetrieveData>
    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("Images")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info_, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        dataList = ArrayList()
        adapter = InfoAdapter(requireContext(), dataList)
        recyclerView.setHasFixedSize(false)
        recyclerView.adapter = adapter

        // Set item click listener in the adapter
        adapter.setOnItemClickListener(object : InfoAdapter.OnItemClickListener {
            override fun onItemClick(item: RetrieveData) {
                // Handle item click, navigate to SecondActivity
                val intent = Intent(requireContext(), Deatils_InfoActivity::class.java)
                intent.putExtra("heading", item.caption ?: "") // Pass caption as heading
                intent.putExtra("paragraph", item.paragraph ?: "") // Pass paragraph
                startActivity(intent)
            }
        })

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (dataSnapshot in snapshot.children) {
                    val retrieveData = dataSnapshot.getValue(RetrieveData::class.java)
                    retrieveData?.let {
                        dataList.add(it)
                    }
                }
                adapter.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {
               Log.d("InfoFragment", "Failed to read value.", error.toException())
            }
        })
        return view
    }
}
