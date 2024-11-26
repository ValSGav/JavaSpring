package ru.gb.lesson1.homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.stream.Stream;

public class Person {
    private final String firstName;
    private final String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;

        if ( o == null || getClass() != o.getClass() ) return false;

        Person person = (Person) o;

        return new EqualsBuilder()
                    .append( age, person.age )
                    .append( firstName, person.firstName )
                    .append( lastName, person.lastName )
                    .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder( this ).append( "firstName", firstName ).append( "lastName", lastName ).append( "age", age ).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder( 17, 37 ).append( firstName ).append( lastName ).append( age ).toHashCode();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String serialize(){
        Gson gSon = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return  gSon.toJson( this );   }

    static Person deserialize(String json){
        Gson gSon = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gSon.fromJson(json, Person.class );
    }
}
