package com.example.ejemplo.util
import com.example.ejemplo.conversion.Conversion

/**
 * This class resolves only equations that match with this regex:
 * '(?<!\S)a+(?:[-+/^*]+(\d+(?:\.\d+)?|pi))+(?!\S)'
 */
class EquationResolverBasic: EquationResolver {

    override fun resolve(args: Array<Double>, equation: String): Double? {

        if (args.size == 1 && isEquation(equation)) {

            val dividedEquation: MutableList<String> = splitEquation(equation);
            replaceVariable(dividedEquation, args[0])

            var index: Int = 0;
            val basicOperands: Array<String> = arrayOf("^", "*", "/", "+", "-")
            while ( 1 < dividedEquation.size && index < basicOperands.size) {

                resolveOperand(dividedEquation, basicOperands[index])
                index ++
            }

            return dividedEquation[0].toDoubleOrNull()
        }

        return null
    }

    /**
     * This class consider an equation all Strings which match with this regex:
     * '(?<!\S)a+(?:[-+/^*]+(\d+(?:\.\d+)?|pi))+(?!\S)'
     *
     * @param equation A String which represent or not an equation.
     * @return Returm true or false based in if it matches with an equation Structure.
     */
    override fun isEquation(equation: String): Boolean {
        if (equation.equals("a=a")) {
            return true
        }
        val regex: Regex = Regex("(?<!\\S)a+(?:[-+/^*]+(|\\d+(?:\\.\\d+)?|pi))+(?!\\S)")
        return equation.matches(regex);
    }

    private fun splitEquation(equation: String): MutableList<String> {

        val regex: Regex = Regex("(?<=[-+/^*])|(?=[-+/^*])");
        return equation.split(regex).toMutableList()
    }

    private fun replaceVariable(equation: MutableList<String>, replace: Double) {

        val equationSize = equation.size - 1
        for (index in 0..equationSize) {

            if (equation[index] == "a") {

                equation[index] = replace.toString()
            }

            if (equation[index] == "pi") {

                equation[index] = Math.PI.toString()
            }
        }
    }

    private fun resolveOperand(
        equation: MutableList<String>,
        operand: String
        ): MutableList<String> {

        val response: MutableList<String> = mutableListOf()


        var index: Int = 1;
        var simpleSolution: String;
        while (index + 1 < equation.size) {

            if (equation[index].contentEquals(operand)) {

                simpleSolution = doOperation(equation[index-1], equation[index], equation[index+1])
                formatOperandSolution(equation, index, simpleSolution)
            } else {

                index += 2;
            }
        }

        return response
    }

    /**
     * Format the equation list (ex: ['14', '+', '2'] -> [16])
     *
     * @param index It contains de operand position (ex: '^', '*', ...)
     * @return equation is edited so where the operands was now is the solution.
     */
    private fun formatOperandSolution(equation: MutableList<String>, index: Int, replace: String) {

        equation[index-1] = replace;
        equation.removeAt(index);
        equation.removeAt(index);
    }

    private fun doOperation(
        operandLeft: String,
        operation: String,
        operandRight: String
        ): String {

        var response: Double = 0.0;
        when (operation) {
            "-" -> response = operandLeft.toDouble() - operandRight.toDouble()
            "+" -> response = operandLeft.toDouble() + operandRight.toDouble()
            "*" -> response = operandLeft.toDouble() * operandRight.toDouble()
            "/" -> response = operandLeft.toDouble() / operandRight.toDouble()
            "^" -> response = Math.pow(operandLeft.toDouble(), operandRight.toDouble())
        }

        return response.toString();
    }
}