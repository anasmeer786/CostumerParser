/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.termproject;
import org.parboiled.Parboiled;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.common.StringUtils;
import static org.parboiled.support.ParseTreeUtils.printNodeTree;
import org.parboiled.support.ParsingResult;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CostomerFormParser parser = Parboiled.createParser(CostomerFormParser.class);
       
        while (true) {
            System.out.print("Welcome to the customer form. Please enter name, address, and phone number.\n");
           
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            input += scan.nextLine();
            input += scan.nextLine();
            if (input.isEmpty()) break;

            ParsingResult<?> result = new RecoveringParseRunner(parser.Customer()).run(input);

            System.out.println('\n' + input + " = " + result.parseTreeRoot.getValue() + '\n');
            System.out.println(printNodeTree(result) + '\n');

            if (!result.matched) {
                System.out.println(StringUtils.join(result.parseErrors, "---\n"));
            }
        }
    }

}