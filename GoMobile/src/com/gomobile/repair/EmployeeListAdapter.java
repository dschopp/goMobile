package com.gomobile.repair;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gomobile.Overviewer;
import com.gomobile.R;
import com.gomobile.model.Bike;
import com.gomobile.model.Employee;
import com.gomobile.shoppingcart.ShoppingCartItem;

/**
 * Own ListAdapter to integrate the view "pickuplist_items"
 * An adapter manages the data model and adapts it to the individual rows in the list view.
 *
 */
public class EmployeeListAdapter extends ArrayAdapter<Employee> {
	private Context context;
	private int layoutResourceId;
	private List<Employee> allEmployees;
	private Employee currentEmployee;
	
	public EmployeeListAdapter(Context context,int layoutResourceId, List<Employee> allEmployees) {
		
		super(context, layoutResourceId, allEmployees);
		
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.allEmployees = allEmployees;
	}
	
	// Override method to fill the view with a individulized rowlayout
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			convertView = inflater.inflate(layoutResourceId, parent, false);
		}
		// Find the bike to work with
		currentEmployee = allEmployees.get(position);

		// Fill the view items with values
		ImageView imageView = (ImageView) convertView.findViewById(R.id.employeePicTeaser);
		TextView lastName = (TextView) convertView.findViewById(R.id.employeeLastNameTeaser);
		TextView firstName = (TextView) convertView.findViewById(R.id.employeeFirstNameTeaser);
		
		
		switch (position) {
		case 0:
			imageView.setImageResource(com.gomobile.R.drawable.bored_face);
			break;
			
		case 1:
			imageView.setImageResource(com.gomobile.R.drawable.face_man_long);
			break;
		
			
		case 2:
			imageView.setImageResource(com.gomobile.R.drawable.man_face_clean_cut_t);
			break;
			
		default:
			break;
			
		}
		
		
		firstName.setText(currentEmployee.getFirstName());
		lastName.setText(currentEmployee.getLastName());
				
		return convertView;
	}
}