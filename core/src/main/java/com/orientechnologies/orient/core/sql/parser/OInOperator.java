/* Generated By:JJTree: Do not edit this line. OInOperator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.Collection;
import java.util.Iterator;

public class OInOperator extends SimpleNode implements OBinaryCompareOperator {
  public OInOperator(int id) {
    super(id);
  }

  public OInOperator(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override
  public boolean execute(Object left, Object right) {
    if (left == null) {
      return false;
    }
    if (right instanceof Collection) {
      if (left instanceof Collection) {
        return ((Collection) right).containsAll((Collection) left);
      }
      if (left instanceof Iterable) {
        left = ((Iterable) left).iterator();
      }
      if (left instanceof Iterator) {
        Iterator iterator = (Iterator) left;
        while (iterator.hasNext()) {
          Object next = iterator.next();
          if (!((Collection) right).contains(next)) {
            return false;
          }
        }
      }
      return ((Collection) right).contains(left);
    }
    if (right instanceof Iterable) {
      right = ((Iterable) right).iterator();
    }
    if (right instanceof Iterator) {
      if (left instanceof Iterable) {
        left = ((Iterable) left).iterator();
      }
      Iterator leftIterator = (Iterator) left;
      Iterator rightIterator = (Iterator) right;
      while (leftIterator.hasNext()) {
        Object leftItem = leftIterator.next();
        boolean found = false;
        while (rightIterator.hasNext()) {
          Object rightItem = rightIterator.next();
          if (leftItem != null && leftItem.equals(rightItem)) {
            found = true;
            break;
          }
        }
        if (!found) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
/* JavaCC - OriginalChecksum=6650a720cb942fa3c4d588ff0f381b3a (do not edit this line) */
