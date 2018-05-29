package br.ufrpe.deinfo.aoc.mips.example;

import java.io.IOException;

import br.ufrpe.deinfo.aoc.mips.MIPS;
import br.ufrpe.deinfo.aoc.mips.Simulator;
import br.ufrpe.deinfo.aoc.mips.State;
import jline.console.ConsoleReader;

public class MyMIPS implements MIPS{
	
	// Atributo que representa o console externo, ser� manipulado no main
	@SuppressWarnings("unused")
	private ConsoleReader console;
	
	/* Este m�todo executa uma instru��o por vez
	 * 
	 * Recebe a instru��o atual que est� armazenada no registrador PC
	 * Program Counter. Esta instru��o � manipulada de acordo com seu tipo: I, R, J.
	 * 
	 * Ap�s a itera��o da instru��o atual o PC � incrementado em 4 Bytes, pois
	 * na arquitetura MIPS cada endere�o de mem�ria possui 4 Bytes, ou seja, 32
	 * bits.
	 */
	@Override
	public void execute(State state) throws Exception {
		/*  Se o Adress de PC for 0x00000000, ent�o
		 *	alteramos o endere�o de $gp com 0x00001800
		 *	e o endere�o de $sp com 0x00003ffc.
		 *
		 *	CARACTER�STICAS DO MEMORY
		 *  CONFIGURATION DO MARS4_5
		 *	
		 *	precisamos alterar esses registradores
		 *  pois nesse simulador n�o possuimos 4gb
		 *  de mem�ria.
		 *  
		 *  $gp � o registrador 28
		 *  $sp � o registrador 29
		 */
		if(state.getPC().equals(0)) {
			state.writeRegister(28, 0x1800);
			state.writeRegister(29, 0x3ffc);
		}
		
		String instrucaoAtual = Integer.toBinaryString(state.readInstructionMemory(state.getPC()));
		String opCode = instrucaoAtual.substring(0, 6);
		
		switch(opCode) {
		case "tipo i":
			
			break;
		case "tipo r":
			
			break;
		case "tipo j":
	
			break;
		}
		
		state.setPC(state.getPC()+4); // somando 4 bytes no valor do PC
	}
	
	// comandos do tipo I
	public static void comandoI(State state, String instrucaoAtual) throws IOException{
		
	}
	
	// comandos do tipo R
	public static void comandoR(State state, String instrucaoAtual) throws IOException{
		
	}
	
	// comandos do tipo J
	public static void comandoJ(State state, String instrucaoAtual) throws IOException{
		
	}
	
	// M�todo respons�vel por transformar todos os 32 bits da palavra bin�ria
	// ,que inicialmente est� no tipo Integer, numa string.
	// � necess�rio esse m�todo pois sem ele ocorrer� perda de bits
	// e a opera��o atual ficar� alterada
	public static String converterEmString(Integer palavra) {
		//	TODO 
		return "";
	}
	
	// Construtor da classe
	public MyMIPS() throws IOException {
		this.console = Simulator.getConsole();
	}
	
	// Main que executar� o console externo do simulador
	public static void main(String[] args) {
		try {
			Simulator.setMIPS(new MyMIPS());
			Simulator.setLogLevel(Simulator.LogLevel.INFO);
			Simulator.start();
		} catch (Exception e) {		
			e.printStackTrace();
		}		
	}
}
