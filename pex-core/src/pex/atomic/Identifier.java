/*  */
package pex.atomic;

import pex.Expression;
import pex.Value;
import pex.Visitor;

/**
 * Class for describing syntactic tree leaves for holding identifier values.
 */
public class Identifier extends Expression implements Comparable<Identifier>{

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /** Identifier name. */
  private String _name;

  /**
   * @param name
   */
  public Identifier(String name) {
    _name = name;
  }

  /**
   * @return the name
   */
  public String getName() {
    return _name;
  }
  
  /**
   * @return int, override the hashcode to apply the hashmap to identifiers
   */
  @Override
  public int hashCode(){
    return _name.hashCode();
  }
  
  /**
   * @return boolean, overrides the object comparison of the hashmap
   */
  @Override
  public boolean equals(Object o){
    if(o instanceof Identifier){
        Identifier identifier = (Identifier) o;
        return this.getName().equals(identifier.getName());
    }
    return false;
  }
  
  
  /** Funcao necessaria para comparar os nomes dos identifiers no hashmap
  * @return int
  */
  @Override
  public int compareTo(Identifier id){
    return this.getName().compareTo(id.getName());
  }
  
  /** Definida em pex.Expression
  * @return Value
  * @param Visitor
  */
  public Value<?> accept(Visitor v){
    return v.visitIDENTIFIER(this);
  }
}
