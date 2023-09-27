package alterar.utils;

import Ardsl.impl.ClassImpl;
import Ardsl.impl.PhysicClassImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Utils {
	private Map<String, Integer> currentId = new HashMap<String, Integer>();
	private Map<String,  ArrayList<ClassImpl>> currentCollisions = new HashMap<String, ArrayList<ClassImpl>>();
	
	public int getId(ArrayList<PhysicClassImpl> list, String cl) {
		int i = 0, id = 0;
		for(i=0;i<list.size();i++) {
			id = (int) Math.pow(2, i);
			PhysicClassImpl aux = list.get(i);
			if(cl.equals(aux.getOntoClass().getName())) {
				break;
			}
		}
		currentId.put(cl, id);
		return id;
	}
	public int getCollisionContact(ArrayList<PhysicClassImpl> list, ArrayList<ClassImpl> cl, String c) {
		int i = 0, id = 1, result = 0;
		for(i=0;i<list.size();i++) {
			id = (int) Math.pow(2, i);
			PhysicClassImpl aux = list.get(i);
			for(int j=0;j< cl.size();j++) {
				if(cl.get(j).getName().equals(aux.getOntoClass().getName())) {
					result+=id;
				}
			}
		}
		currentCollisions.put(c, cl);
		return result;
	}
	public int getReflexCollision(String c) {
		int result = 0;
		Set<String> set = currentCollisions.keySet();
		for(String s : set) {
			ArrayList<ClassImpl> ar = currentCollisions.get(s);
			for(ClassImpl a : ar) {
				if(a.getName() == c) {
					result += currentId.get(s);
				}
			}
		}
		return result;
	}
}