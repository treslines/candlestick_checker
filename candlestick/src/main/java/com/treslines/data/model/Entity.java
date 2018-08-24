/*
Copyright 2018 Ricardo Ferreira

Permission is hereby granted, free of charge, to any person obtaining a copy 
of this software and associated documentation files (the "Software"), to deal 
in the Software without restriction, including without limitation the rights 
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies 
of the Software, and to permit persons to whom the Software is furnished to do 
so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all 
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.treslines.data.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;

/**
 * Every database entity class shall extend this base class in order to 
 * inherit the query param utility methods and id definition.
 * 
 * @author Ricardo Ferreira
 * @since 31/07/2018
 * @version 1.0.0
 */
public abstract class Entity {
	
	@DatabaseField(generatedId = true)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Use this method to obtain all entity's field names exactly as they are declared,
	 * except those ones that you are excluding over the exclude param.
	 * 
	 * This method will be helpful while validating attributes over the class {@link Validator}
	 * 
	 * @param include entity's field names like: 'name', 'age"
	 * @return as list of entity's field exactly as they are declared
	 * @param exclude the entity's field names to be excluded from the list
	 * @return a list of entity's field exactly as they are declared
	 */
	public List<String> excludeQueryParams(String... exclude) {
		List<Boolean> exclussion = new ArrayList<>();
		List<String> queryParams = new ArrayList<>();
		for (Field param : getClass().getDeclaredFields()) {
			for (String toExclude : exclude) {
				if(toExclude!=null && toExclude.equalsIgnoreCase(param.getName())){
					exclussion.add(true);
					break;
				}
			}
			if(!exclussion.contains(true)){
				queryParams.add(param.getName());
			}
			exclussion.clear();
		}
		return queryParams;
	}
	

}
