/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.termproject;

import org.parboiled.BaseParser;
import org.parboiled.Parboiled;
import org.parboiled.Rule;

import org.parboiled.annotations.BuildParseTree;

@BuildParseTree
public class CostomerFormParser extends BaseParser<Object> {

 public Rule Customer() {
       return Sequence(
               Name(),
               newLine(),
               Address(),
               newLine(),
               PhoneNumber());
   }
   
   public Rule Name() {
       return Sequence(
               FName(),
               Space(),
               FirstOf(
                       Sequence(MName(), Space(), LName()),
                       LName()
               ));    
   }
   
   public Rule Address() {
       return Sequence(
               StreetNum(),
               OneOrMore(
                       Space(),
                       StreetName()),
               Comma(),
               OneOrMore(
                       Space(),
                       City()),
               Comma(),
               OneOrMore(
                       Space(),
                       StateOrProvince()),
               Comma(),
               OneOrMore(
                       Space(),
                       Country()));
   }
   
    public Rule PhoneNumber() {
        return Sequence(
                Parentheses(), Number(), Number(), Number(), Parentheses(),
                Space(),
                Number(), Number(), Number(),
                Hyphen(),
                Number(), Number(), Number(), Number());
    }
   
   public Rule StreetNum() {
       return OneOrMore(Number());
   }
   
   public Rule StreetName() {
       return Sequence(
               CapLetter(),
               OneOrMore(Letter()),
               Optional(
                       Ch('.')));
   }
   
   public Rule City() {
       return Sequence(CapLetter(),
               OneOrMore(Letter()));
   }
   
   public Rule StateOrProvince() {
       return FirstOf(
               Sequence(CapLetter(), CapLetter()),
               Sequence(CapLetter(), OneOrMore(Letter())));
   }
   
   public Rule Country() {
       return FirstOf(
               Sequence(CapLetter(),OneOrMore(Letter())),
               OneOrMore(CapLetter()),
               OneOrMore(Letter()));
   }
   
   public Rule FName() {
       return Sequence(
               CapLetter(),
               OneOrMore(Letter()));
   }
   
   public Rule LName() {
       return Sequence(
               CapLetter(),
               OneOrMore(Letter()));
   }
   
   public Rule MName() {
       return Sequence(
               CapLetter(),
               Optional(Ch('.')),
               Optional(
                       OneOrMore(Letter())));
   }
   
    public Rule newLine() {
        return String("\n");
    }
   
   public Rule Space(){
       return ZeroOrMore(" ");
    }
   
   public Rule Comma() {
       return Ch(',');
   }
   
    public Rule Number() {
        return CharRange('0','9');
    }

   public Rule Letter() {
       return CharRange('a', 'z');  
   }
   
   public Rule CapLetter() {
       return CharRange('A', 'Z');
   }
   
    public Rule Hyphen() {
        return Ch('-');
    }
   
    public Rule Parentheses() {
        return AnyOf("()");
    }
   
}
/*public class CostomerFormParser extends BaseParser<Object> {

    public Rule CustomerForm() {
        return Sequence(Name(), StreetAddress(), City(), StateOrProvince(), Country(), PhoneNumber(), EOI);
    }

    public Rule Address() {
        return Sequence(StreetAddress(), City(), StateOrProvince(), Country());
    }

    public Rule Name() {
        return Sequence(FirstName(), Optional(MiddleName()), LastName());
    }

    public Rule FirstName() {
        return Sequence(UppercaseLetter(), LowercaseLetters());
    }

    public Rule MiddleName() {
        return Sequence(UppercaseLetter(), Optional(LowercaseLetters()), Ch('.'), Ch(' '));
    }

    public Rule LastName() {
        return Sequence(UppercaseLetter(), LowercaseLetters());
    }

    public Rule LowercaseLetters() {
        return OneOrMore(CharRange('a', 'z'));
    }

    public Rule UppercaseLetter() {
        return CharRange('A', 'Z');
    }

    public Rule StreetAddress() {
        return Sequence(
                OneOrMore(FirstOf(
                        LetterOrDigit(),
                        AnyOf(".,-/\\#() "),
                        Ch('\n')
                )),
                EOI // Ensure that the street address ends with the end of input
        );
    }

    public Rule LetterOrDigit() {
        return FirstOf(
                CharRange('a', 'z'),
                CharRange('A', 'Z'),
                CharRange('0', '9')
        );
    }

    public Rule City() {
        return Sequence(UppercaseLetter(), LowercaseLetters());
    }

    public Rule StateOrProvince() {
        return Sequence(UppercaseLetter(), LowercaseLetters());
    }

    public Rule Country() {
        return Sequence(UppercaseLetter(), LowercaseLetters());
    }

    public Rule PhoneNumber() {
        return Sequence('(', Digit(), Digit(), Digit(), ')', Ch(' '), Digit(), Digit(), Digit(), Ch('-'), Digit(), Digit(), Digit(), Digit());
    }

    public Rule Digit() {
        return CharRange('0', '9');
    }
}
*/