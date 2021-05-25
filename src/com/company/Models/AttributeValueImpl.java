package com.company.Models;

public class AttributeValueImpl<E> implements AttributeValue {
   E value;

   public E getValue() {
      return value;
   }

   public void setValue(E value)
   {
      this.value = value;
   }

   public boolean compareType(Object value1)
   {
      E val = (E) value1;
      return value.getClass().equals(val.getClass());
   }


   @Override
   public boolean equals(Object value1) {
      E val1 = (E) value1;
      return val1.equals(this.value);
   }

   @Override
   public String toString()
   {
      return value.toString();
   }
}
