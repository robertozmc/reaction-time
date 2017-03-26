import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.stream.IntStream;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainWindow extends JFrame 
{

	private JPanel panelGlowny;
	private JPanel panelTestProsty;
	private JPanel panelTestZlozony;
	private JPanel panelPomocProsty;
	private JPanel panelPomocZlozony;
	private JPanel panelProbaProsty;
	private JPanel panelProbaZlozony;
	private JPanel panelWynikiProsty;
	private JPanel panelWynikiZlozony;
	
	private ImageIcon screenP = new ImageIcon(getClass().getResource("screenP.png"));
	private ImageIcon screenP1 = new ImageIcon(getClass().getResource("screenP1.png"));
	private ImageIcon screenP2 = new ImageIcon(getClass().getResource("screenP2.png"));
	private ImageIcon screenP3 = new ImageIcon(getClass().getResource("screenP3.png"));
	static ImageIcon lights = new ImageIcon(MainWindow.class.getResource("lights.png"));
	static ImageIcon greenLight = new ImageIcon(MainWindow.class.getResource("greenLight.png"));
	static ImageIcon yellowLight = new ImageIcon(MainWindow.class.getResource("yellowLight.png"));
	static ImageIcon redLight = new ImageIcon(MainWindow.class.getResource("redLight.png"));
	private ImageIcon speaker = new ImageIcon(getClass().getResource("speaker.png"));
	private ImageIcon stop = new ImageIcon(getClass().getResource("stop.png"));
	
	static JLabel light1;
	static JLabel light2;
	static JLabel light3;
	static JLabel light4;
	
	String czasReakcjiProba;
	String czasReakcjiTest;
	
	int counterP = 0;
	int counterZ = 0;
	
	int y = 50;
	int z = 50;
	int i = 0;
	int j = 0;
	
	private boolean isSpacePressed = false;
			
	/**
	 * Konstruktor okna.
	 */
	
	public MainWindow()
	{

		int[] sr;
		sr = new int[10];
		
		Timer myTimer = new Timer();
		
		setTitle("Reflex meter");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 112, 1200, 800);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnTest = new JMenu("TEST");
		mnTest.setForeground(Color.WHITE);
		menuBar.add(mnTest);
		
		JMenuItem mntmProstyCzasReakcji = new JMenuItem("Prosty czas reakcji");
		mnTest.add(mntmProstyCzasReakcji);
		
		JSeparator separator = new JSeparator();
		mnTest.add(separator);
		
		JMenuItem mntmZlozonyCzasReakcji = new JMenuItem("Z³o¿ony czas reakcji");
		mnTest.add(mntmZlozonyCzasReakcji);
		
		/**
		 * Tworzenie panelu g³ównego.
		 */
		
		panelGlowny = new JPanel();
		panelGlowny.setBackground(Color.BLACK);
		panelGlowny.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGlowny.setLayout(null);
		setContentPane(panelGlowny);
		
		JLabel powitanie = new JLabel("TESTER SPRAWNOŒCI PSYCHOMOTORYCZNEJ");
		JLabel powitanie1 = new JLabel("dla");
		JLabel powitanie2 = new JLabel("kandydatów na kierowców");
		JLabel powitanie3 = new JLabel("Aby rozpocz¹æ test, przejdŸ do odpowiedniej pozycji w menu TEST");
		
		powitanie.setBounds(100,100,1000,100);
		powitanie.setFont(new Font("Calibri", Font.BOLD, 50));
		powitanie.setForeground(Color.WHITE);
		powitanie.setHorizontalAlignment(SwingConstants.CENTER);
		
		powitanie1.setBounds(100,200,1000,100);
		powitanie1.setFont(new Font("Calibri", Font.ITALIC, 50));
		powitanie1.setForeground(Color.WHITE);
		powitanie1.setHorizontalAlignment(SwingConstants.CENTER);
		
		powitanie2.setBounds(100,300,1000,100);
		powitanie2.setFont(new Font("Calibri", Font.BOLD, 50));
		powitanie2.setForeground(Color.WHITE);
		powitanie2.setHorizontalAlignment(SwingConstants.CENTER);
		
		powitanie3.setBounds(100,400,1000,100);
		powitanie3.setFont(new Font("Calibri", Font.ITALIC, 25));
		powitanie3.setForeground(Color.WHITE);
		powitanie3.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelGlowny.add(powitanie);
		panelGlowny.add(powitanie1);
		panelGlowny.add(powitanie2);
		panelGlowny.add(powitanie3);
		
		/**
		 * Tworzenie panelu pomocy dla testu prostego.
		 */
		
		panelPomocProsty = new JPanel();
		panelPomocProsty.setBackground(Color.BLACK);
		panelPomocProsty.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPomocProsty.setLayout(null);
	
		JLabel pomocP = new JLabel("TEST CZASU REAKCJI PROSTEJ");
		JLabel pomocP1 = new JLabel("<html><p align=justify>Na pulpicie programu pomiarowego emitowane s¹ "
				+ "sygna³y w postaci zapalaj¹cych siê œwiate³ w trzech kolorach: czerwonym, ¿ó³tym i zielonym "
				+ "oraz sygna³ dŸwiêkowy. £¹cznie emitowanych jest 10 sygna³ów.<br><br> Zadanie osoby badanej polega "
				+ "na reagowaniu na ka¿dy rodzaj sygna³u poprzez naciskanie przycisku widocznego na ekranie.</p></html>");
		
		pomocP.setBounds(100,100,1000,60);
		pomocP.setFont(new Font("Calibri", Font.BOLD, 50));
		pomocP.setForeground(Color.WHITE);
		pomocP.setHorizontalAlignment(SwingConstants.CENTER);
		
		pomocP1.setBounds(50,100,500,500);
		pomocP1.setFont(new Font("Calibri", Font.PLAIN, 20));
		pomocP1.setForeground(Color.WHITE);
		pomocP1.setHorizontalAlignment(SwingConstants.LEFT);
				
		panelPomocProsty.add(pomocP);
		panelPomocProsty.add(pomocP1);
		
		JButton btnTestP = new JButton("Wykonaj test");
		btnTestP.setBounds(400,650,150,50);
		
		JButton btnProbaP = new JButton("Wykonaj próbê");
		btnProbaP.setBounds(650,650,150,50);
		
		panelPomocProsty.add(btnTestP);
		panelPomocProsty.add(btnProbaP);
		
		JLabel screen1 = new JLabel(screenP);
		screen1.setBounds(650,100,500,600);
		panelPomocProsty.add(screen1);
		
		/**
		 * Tworzenie panelu pomocy dla testu z³o¿onego.
		 */
		
		panelPomocZlozony = new JPanel();
		panelPomocZlozony.setBackground(Color.BLACK);
		panelPomocZlozony.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPomocZlozony.setLayout(null);
		
		JLabel pomocZ = new JLabel("TEST CZASU REAKCJI Z£O¯ONEJ");
		JLabel pomocZ1 = new JLabel("<html><p align=justify>Na ekranie programu pomiarowego wyœwietlane s¹ "
				+ "sygna³y w postaci œwiate³ w trzech kolorach: czerwonym, ¿ó³tym i zielonym zaœ g³oœnik emituje "
				+ "sygna³ dŸwiêkowy. £¹czna liczba emitowanych sygna³ów wynosi 10.<br><br> Zadaniem osoby badanej jest "
				+ "reagowanie na pojawiaj¹ce siê sygna³y wg. nastêpuj¹cego klucza:<br><br>"
				+ "œwiat³o czerwone - wciœniêcie lewym przyciskiem myszy przycisku widocznego na ekranie,<br>"
				+ "œwiat³o zielone - wciœniêcie prawym przyciskiem myszy przycisku na ekranie,<br>"
				+ "œwiat³o ¿ó³te - wciœniêcie œrodkowym przyciskiem myszy przycisku na ekranie,<br>"
				+ "sygna³ dŸwiêkowy - naciœniêcie klawisza Spacji na klawiaturze.</p></html>");
		
		pomocZ.setBounds(100,100,1000,60);
		pomocZ.setFont(new Font("Calibri", Font.BOLD, 50));
		pomocZ.setForeground(Color.WHITE);
		pomocZ.setHorizontalAlignment(SwingConstants.CENTER);
		
		pomocZ1.setBounds(50,100,500,600);
		pomocZ1.setFont(new Font("Calibri", Font.PLAIN, 20));
		pomocZ1.setForeground(Color.WHITE);
		pomocZ1.setHorizontalAlignment(SwingConstants.LEFT);
				
		panelPomocZlozony.add(pomocZ);
		panelPomocZlozony.add(pomocZ1);
		
		JButton btnTestZ = new JButton("Wykonaj test");
		btnTestZ.setBounds(400,650,150,50);
		
		JButton btnProbaZ = new JButton("Wykonaj próbê");
		btnProbaZ.setBounds(650,650,150,50);
		
		panelPomocZlozony.add(btnTestZ);
		panelPomocZlozony.add(btnProbaZ);
		
		JLabel screen2 = new JLabel(screenP);
		screen2.setBounds(650,100,500,600);
		panelPomocZlozony.add(screen2);
		
		/**
		 * Tworzenie panelu testu prostego.
		 */
		
		panelTestProsty = new JPanel();
		panelTestProsty.setBackground(Color.BLACK);
		panelTestProsty.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelTestProsty.setLayout(null);
		
		JLabel background1 = new JLabel(new ImageIcon(getClass().getResource("background.png")));
		background1.setBounds(0,0,1200,800);
		background1.setLayout(null);
		panelTestProsty.add(background1);
		
		JLabel speaker1 = new JLabel(speaker);
		speaker1.setBounds(825, 250, 213, 210);
		panelTestProsty.add(speaker1);
		background1.add(speaker1);
		
		light1 = new JLabel(lights);
		light1.setBounds(501,140,197,500);
		panelTestProsty.add(light1);
		background1.add(light1);
		
		JButton stop1 = new JButton(stop);
		stop1.setOpaque(false);
		stop1.setContentAreaFilled(false);
		stop1.setBorderPainted(false);
		stop1.setBounds(150, 280, 150, 152);
		panelTestProsty.add(stop1);
		background1.add(stop1);
		
		/**
		 * Tworzenie panelu testu z³o¿onego.
		 */
		
		panelTestZlozony = new JPanel();
		panelTestZlozony.setBackground(Color.BLACK);
		panelTestZlozony.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelTestZlozony.setLayout(null);
		
		JLabel background2 = new JLabel(new ImageIcon(getClass().getResource("background.png")));
		background2.setBounds(0,0,1200,800);
		background2.setLayout(null);
		panelTestZlozony.add(background2);
		
		JLabel speaker2 = new JLabel(speaker);
		speaker2.setBounds(825, 250, 213, 210);
		panelTestZlozony.add(speaker2);
		background2.add(speaker2);
		
		light2 = new JLabel(lights);
		light2.setBounds(501,140,197,500);
		panelTestZlozony.add(light2);
		background2.add(light2);
		
		JButton stop2 = new JButton(stop);
		stop2.setOpaque(false);
		stop2.setContentAreaFilled(false);
		stop2.setBorderPainted(false);
		stop2.setBounds(150, 280, 150, 152);
		panelTestZlozony.add(stop2);
		background2.add(stop2);
		
		JLabel wynikTestuZlozonego1 = new JLabel();
		wynikTestuZlozonego1.setFont(new Font("Calibri", Font.BOLD, 50));
		wynikTestuZlozonego1.setForeground(Color.WHITE);
		wynikTestuZlozonego1.setHorizontalAlignment(SwingConstants.CENTER);
		wynikTestuZlozonego1.setBounds(125,100,200,60);
		panelTestZlozony.add(wynikTestuZlozonego1);
		background2.add(wynikTestuZlozonego1);
		
		/**
		 * Tworzenie panelu wyniku dla testu prostego.
		 */
		
		panelWynikiProsty = new JPanel();
		panelWynikiProsty.setBackground(Color.BLACK);
		panelWynikiProsty.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelWynikiProsty.setLayout(null);
		
		JLabel wyniki = new JLabel("Wyniki");
		wyniki.setBounds(100,25,1000,100);
		wyniki.setFont(new Font("Calibri", Font.BOLD, 50));
		wyniki.setForeground(Color.WHITE);
		wyniki.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelWynikiProsty.add(wyniki);
		
		JLabel sygnal1 = new JLabel("Sygna³ 1");
		sygnal1.setBounds(300,100,200,50);
		sygnal1.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal1.setForeground(Color.WHITE);
		sygnal1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnal2 = new JLabel("Sygna³ 2");
		sygnal2.setBounds(300,150,200,50);
		sygnal2.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal2.setForeground(Color.WHITE);
		sygnal2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnal3 = new JLabel("Sygna³ 3");
		sygnal3.setBounds(300,200,200,50);
		sygnal3.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal3.setForeground(Color.WHITE);
		sygnal3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnal4 = new JLabel("Sygna³ 4");
		sygnal4.setBounds(300,250,200,50);
		sygnal4.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal4.setForeground(Color.WHITE);
		sygnal4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnal5 = new JLabel("Sygna³ 5");
		sygnal5.setBounds(300,300,200,50);
		sygnal5.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal5.setForeground(Color.WHITE);
		sygnal5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnal6 = new JLabel("Sygna³ 6");
		sygnal6.setBounds(300,350,200,50);
		sygnal6.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal6.setForeground(Color.WHITE);
		sygnal6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnal7 = new JLabel("Sygna³ 7");
		sygnal7.setBounds(300,400,200,50);
		sygnal7.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal7.setForeground(Color.WHITE);
		sygnal7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnal8 = new JLabel("Sygna³ 8");
		sygnal8.setBounds(300,450,200,50);
		sygnal8.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal8.setForeground(Color.WHITE);
		sygnal8.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnal9 = new JLabel("Sygna³ 9");
		sygnal9.setBounds(300,500,200,50);
		sygnal9.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal9.setForeground(Color.WHITE);
		sygnal9.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnal10 = new JLabel("Sygna³ 10");
		sygnal10.setBounds(300,550,200,50);
		sygnal10.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnal10.setForeground(Color.WHITE);
		sygnal10.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel srednia = new JLabel("Œrednia");
		srednia.setBounds(300,600,200,50);
		srednia.setFont(new Font("Calibri", Font.PLAIN, 25));
		srednia.setForeground(Color.WHITE);
		srednia.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel srednia1 = new JLabel();
		srednia1.setBounds(500,600,600,50);
		srednia1.setFont(new Font("Calibri", Font.BOLD, 25));
		srednia1.setForeground(Color.WHITE);
		srednia1.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelWynikiProsty.add(sygnal1);
		panelWynikiProsty.add(sygnal2);
		panelWynikiProsty.add(sygnal3);
		panelWynikiProsty.add(sygnal4);
		panelWynikiProsty.add(sygnal5);
		panelWynikiProsty.add(sygnal6);
		panelWynikiProsty.add(sygnal7);
		panelWynikiProsty.add(sygnal8);
		panelWynikiProsty.add(sygnal9);
		panelWynikiProsty.add(sygnal10);
		panelWynikiProsty.add(srednia);
		panelWynikiProsty.add(srednia1);
		
		JButton wyjscieP = new JButton("Menu g³ówne");
		wyjscieP.setBounds(1000,650,150,50);
		panelWynikiProsty.add(wyjscieP);
		
		/**
		 * Tworzenie panelu wyniku dla testu z³o¿onego.
		 */
		
		panelWynikiZlozony = new JPanel();
		panelWynikiZlozony.setBackground(Color.BLACK);
		panelWynikiZlozony.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelWynikiZlozony.setLayout(null);
		
		JLabel wyniki1 = new JLabel("Wyniki");
		wyniki1.setBounds(100,25,1000,100);
		wyniki1.setFont(new Font("Calibri", Font.BOLD, 50));
		wyniki1.setForeground(Color.WHITE);
		wyniki1.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelWynikiZlozony.add(wyniki1);
		
		JLabel sygnalz1 = new JLabel("Sygna³ 1");
		sygnalz1.setBounds(300,100,200,50);
		sygnalz1.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz1.setForeground(Color.WHITE);
		sygnalz1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnalz2 = new JLabel("Sygna³ 2");
		sygnalz2.setBounds(300,150,200,50);
		sygnalz2.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz2.setForeground(Color.WHITE);
		sygnalz2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnalz3 = new JLabel("Sygna³ 3");
		sygnalz3.setBounds(300,200,200,50);
		sygnalz3.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz3.setForeground(Color.WHITE);
		sygnalz3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnalz4 = new JLabel("Sygna³ 4");
		sygnalz4.setBounds(300,250,200,50);
		sygnalz4.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz4.setForeground(Color.WHITE);
		sygnalz4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnalz5 = new JLabel("Sygna³ 5");
		sygnalz5.setBounds(300,300,200,50);
		sygnalz5.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz5.setForeground(Color.WHITE);
		sygnalz5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnalz6 = new JLabel("Sygna³ 6");
		sygnalz6.setBounds(300,350,200,50);
		sygnalz6.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz6.setForeground(Color.WHITE);
		sygnalz6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnalz7 = new JLabel("Sygna³ 7");
		sygnalz7.setBounds(300,400,200,50);
		sygnalz7.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz7.setForeground(Color.WHITE);
		sygnalz7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnalz8 = new JLabel("Sygna³ 8");
		sygnalz8.setBounds(300,450,200,50);
		sygnalz8.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz8.setForeground(Color.WHITE);
		sygnalz8.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnalz9 = new JLabel("Sygna³ 9");
		sygnalz9.setBounds(300,500,200,50);
		sygnalz9.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz9.setForeground(Color.WHITE);
		sygnalz9.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sygnalz10 = new JLabel("Sygna³ 10");
		sygnalz10.setBounds(300,550,200,50);
		sygnalz10.setFont(new Font("Calibri", Font.PLAIN, 25));
		sygnalz10.setForeground(Color.WHITE);
		sygnalz10.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sredniaz = new JLabel("Œrednia");
		sredniaz.setBounds(300,600,200,50);
		sredniaz.setFont(new Font("Calibri", Font.PLAIN, 25));
		sredniaz.setForeground(Color.WHITE);
		sredniaz.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel sredniaz1 = new JLabel();
		sredniaz1.setBounds(500,600,600,50);
		sredniaz1.setFont(new Font("Calibri", Font.BOLD, 25));
		sredniaz1.setForeground(Color.WHITE);
		sredniaz1.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelWynikiZlozony.add(sygnalz1);
		panelWynikiZlozony.add(sygnalz2);
		panelWynikiZlozony.add(sygnalz3);
		panelWynikiZlozony.add(sygnalz4);
		panelWynikiZlozony.add(sygnalz5);
		panelWynikiZlozony.add(sygnalz6);
		panelWynikiZlozony.add(sygnalz7);
		panelWynikiZlozony.add(sygnalz8);
		panelWynikiZlozony.add(sygnalz9);
		panelWynikiZlozony.add(sygnalz10);
		panelWynikiZlozony.add(sredniaz);
		panelWynikiZlozony.add(sredniaz1);
		
		JButton wyjscieZ = new JButton("Menu g³ówne");
		wyjscieZ.setBounds(1000,650,150,50);
		panelWynikiZlozony.add(wyjscieZ);
		
		/**
		 * Tworzenie panelu próby dla testu prostego.
		 */
		
		panelProbaProsty = new JPanel();
		panelProbaProsty.setBackground(Color.BLACK);
		panelProbaProsty.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelProbaProsty.setLayout(null);
		
		JLabel background3 = new JLabel(new ImageIcon(getClass().getResource("background.png")));
		background3.setBounds(0,0,1200,800);
		background3.setLayout(null);
		panelProbaProsty.add(background3);
		
		JLabel speaker3 = new JLabel(speaker);
		speaker3.setBounds(825, 250, 213, 210);
		panelProbaProsty.add(speaker3);
		background3.add(speaker3);
		
		light3 = new JLabel(lights);
		light3.setBounds(501,140,197,500);
		panelProbaProsty.add(light3);
		background3.add(light3);
		
		JButton stop3 = new JButton(stop);
		stop3.setOpaque(false);
		stop3.setContentAreaFilled(false);
		stop3.setBorderPainted(false);
		stop3.setBounds(150, 280, 150, 152);
		panelProbaProsty.add(stop3);
		background3.add(stop3);
		
		JLabel wynikTestuProstego = new JLabel();
		wynikTestuProstego.setFont(new Font("Calibri", Font.BOLD, 50));
		wynikTestuProstego.setForeground(Color.WHITE);
		wynikTestuProstego.setHorizontalAlignment(SwingConstants.CENTER);
		wynikTestuProstego.setBounds(125,100,200,60);
		panelTestProsty.add(wynikTestuProstego);
		background3.add(wynikTestuProstego);
		
		JButton btnPowrotP = new JButton("Cofnij");
		btnPowrotP.setBounds(1000,650,150,50);
		background3.add(btnPowrotP);
		
		/**
		 * Tworzenie panelu próby dla testu z³o¿onego.
		 */
		
		panelProbaZlozony = new JPanel();
		panelProbaZlozony.setBackground(Color.BLACK);
		panelProbaZlozony.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelProbaZlozony.setLayout(null);
		
		JLabel background4 = new JLabel(new ImageIcon(getClass().getResource("background.png")));
		background4.setBounds(0,0,1200,800);
		background4.setLayout(null);
		panelProbaZlozony.add(background4);
		
		JLabel speaker4 = new JLabel(speaker);
		speaker4.setBounds(825, 250, 213, 210);
		panelProbaZlozony.add(speaker4);
		background4.add(speaker4);
		
		light4 = new JLabel(lights);
		light4.setBounds(501,140,197,500);
		panelProbaZlozony.add(light4);
		background4.add(light4);
		
		JButton stop4 = new JButton(stop);
		stop4.setOpaque(false);
		stop4.setContentAreaFilled(false);
		stop4.setBorderPainted(false);
		stop4.setBounds(150, 280, 150, 152);
		panelProbaZlozony.add(stop4);
		background4.add(stop4);
		
		JLabel wynikTestuZlozonego = new JLabel();
		wynikTestuZlozonego.setFont(new Font("Calibri", Font.BOLD, 50));
		wynikTestuZlozonego.setForeground(Color.WHITE);
		wynikTestuZlozonego.setHorizontalAlignment(SwingConstants.CENTER);
		wynikTestuZlozonego.setBounds(125,100,200,60);
		panelTestZlozony.add(wynikTestuZlozonego);
		background4.add(wynikTestuZlozonego);
		
		JButton btnPowrotZ = new JButton("Cofnij");
		btnPowrotZ.setBounds(1000,650,150,50);
		background4.add(btnPowrotZ);
		
		/**
		 * Tworzenie akcji dla przycisku w menu test prosty.
		 */
		
		mntmProstyCzasReakcji.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				new Thread()
				{
					
					public void run()
					{
						
						try
						{
							
							while (true)
							{
								
								screen1.setIcon(screenP);
								Thread.sleep(1000);
								screen1.setIcon(screenP1);
								Thread.sleep(1000);
								screen1.setIcon(screenP2);
								Thread.sleep(1000);
								screen1.setIcon(screenP3);
								Thread.sleep(1000);
							
							}
							
						} catch (Exception e){}
						
					}
					
				}.start();
				
				setContentPane(panelPomocProsty);
				panelPomocProsty.revalidate();
				panelPomocProsty.repaint();
				
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku w menu test z³o¿ony.
		 */
		
		mntmZlozonyCzasReakcji.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				new Thread()
				{
					
					public void run()
					{
						
						try
						{
							
							while (true)
							{
								
								screen2.setIcon(screenP);
								Thread.sleep(1000);
								screen2.setIcon(screenP1);
								Thread.sleep(1000);
								screen2.setIcon(screenP2);
								Thread.sleep(1000);
								screen2.setIcon(screenP3);
								Thread.sleep(1000);
							
							}
							
						} catch (Exception e){}
						
					}
					
				}.start();
				
				setContentPane(panelPomocZlozony);
				panelPomocZlozony.revalidate();
				panelPomocZlozony.repaint();
				
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku test prosty.
		 */
		
		btnTestP.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				light1.setIcon(lights);
				setContentPane(panelTestProsty);
				panelTestProsty.revalidate();
				panelTestProsty.repaint();
				
				myTimer.schedule(new TimerSygnal(), 5000);
				
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku próba prosty.
		 */
		
		btnProbaP.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				light3.setIcon(lights);
				wynikTestuProstego.setText("");
				setContentPane(panelProbaProsty);
				panelProbaProsty.revalidate();
				panelProbaProsty.repaint();
				
				myTimer.schedule(new TimerSygnal(), 5000);
				
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku test z³o¿ony.
		 */
		
		btnTestZ.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				light2.setIcon(lights);
				setContentPane(panelTestZlozony);
				panelTestZlozony.revalidate();
				panelTestZlozony.repaint();

				myTimer.schedule(new TimerSygnal(), 5000);
							
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku próba z³o¿ony.
		 */
		
		btnProbaZ.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				light4.setIcon(lights);
				wynikTestuZlozonego.setText("");
				setContentPane(panelProbaZlozony);
				panelProbaZlozony.revalidate();
				panelProbaZlozony.repaint();
				
				myTimer.schedule(new TimerSygnal(), 5000);
				
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku powrotu testu prostego.
		 */

		btnPowrotP.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				setContentPane(panelPomocProsty);
				panelPomocProsty.revalidate();
				panelPomocProsty.repaint();
				
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku powrotu testu z³o¿onego.
		 */

		btnPowrotZ.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				setContentPane(panelPomocZlozony);
				panelPomocZlozony.revalidate();
				panelPomocZlozony.repaint();
				
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku stop testu prostego.
		 */
		
		stop1.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
							
				long czasKlikniecia = System.nanoTime();
				long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
				int czasReakcji = (int) (czasR*0.000001);
				czasReakcjiTest = Integer.toString(czasReakcji);
				
				light1.setIcon(lights);
				
				sr[i] = czasReakcji;
				
				counterP++;
				
				if (counterP == 10)
				{
				
					int sum = IntStream.of(sr).sum();
					int sredniaLiczba = sum/10;
					String sredniaTekst = Integer.toString(sredniaLiczba);
					srednia1.setText(sredniaTekst + " ms");
				
				}
				
				i++;
				y+=50;
				
				JLabel czas1 = new JLabel(czasReakcjiTest + " ms");
				czas1.setBounds(500, y, 600, 50);
				czas1.setFont(new Font("Calibri", Font.PLAIN, 25));
				czas1.setForeground(Color.WHITE);
				czas1.setHorizontalAlignment(SwingConstants.CENTER);
				
				panelWynikiProsty.add(czas1);
				
				if (counterP == 10)
				{
					
					setContentPane(panelWynikiProsty);
					panelWynikiProsty.revalidate();
					panelWynikiProsty.repaint();
					
				} else
				{
				
					int czas = (2 + new Random().nextInt(2))*1000;
					myTimer.schedule(new TimerSygnal(), czas);
				
				}
				
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku stop próby prostej.
		 */
		
		stop3.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				long czasKlikniecia = System.nanoTime();
				long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
				int czasReakcji = (int) (czasR*0.000001);
				czasReakcjiProba = Integer.toString(czasReakcji);
				wynikTestuProstego.setText(czasReakcjiProba + " ms");
				
				light3.setIcon(lights);
				
				int czas = (2 + new Random().nextInt(2))*1000;
				myTimer.schedule(new TimerSygnal(), czas);
			
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku stop testu z³o¿onego.
		 */
		
		stop2.addMouseListener(new MouseListener()
		{
			
			public void mouseClicked(MouseEvent e)
			{
				
				if (TimerSygnal.numerSygnalu == 1 && SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) 
				{
					
					long czasKlikniecia = System.nanoTime();
					long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
					int czasReakcji = (int) (czasR*0.000001);
					czasReakcjiTest = Integer.toString(czasReakcji);
					wynikTestuZlozonego1.setText(czasReakcjiTest + " ms");
					
					sr[j] = czasReakcji;
					
					counterZ++;
					
					if (counterZ == 10)
					{
					
						int sum = IntStream.of(sr).sum();
						int sredniaLiczba = sum/10;
						String sredniaTekst = Integer.toString(sredniaLiczba);
						sredniaz1.setText(sredniaTekst + " ms");
					
					}
					
					j++;
					z+=50;
					
					JLabel czas2 = new JLabel(czasReakcjiTest + " ms");
					czas2.setBounds(500, z, 600, 50);
					czas2.setFont(new Font("Calibri", Font.PLAIN, 25));
					czas2.setForeground(Color.WHITE);
					czas2.setHorizontalAlignment(SwingConstants.CENTER);
					
					panelWynikiZlozony.add(czas2);
													
					light2.setIcon(lights);
					
					if (counterZ == 10)
					{
						
						setContentPane(panelWynikiZlozony);
						panelWynikiZlozony.revalidate();
						panelWynikiZlozony.repaint();
						
					} else
					{
					
						int czas = (2 + new Random().nextInt(2))*1000;
						myTimer.schedule(new TimerSygnal(), czas);
					
					}
					
				} else if (TimerSygnal.numerSygnalu == 3 && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1)
				{
					
					long czasKlikniecia = System.nanoTime();
					long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
					int czasReakcji = (int) (czasR*0.000001);
					czasReakcjiTest = Integer.toString(czasReakcji);
					wynikTestuZlozonego1.setText(czasReakcjiTest + " ms");
					
					sr[j] = czasReakcji;
					
					counterZ++;
					
					if (counterZ == 10)
					{
					
						int sum = IntStream.of(sr).sum();
						int sredniaLiczba = sum/10;
						String sredniaTekst = Integer.toString(sredniaLiczba);
						sredniaz1.setText(sredniaTekst + " ms");
					
					}
					
					j++;
					z+=50;
					
					JLabel czas2 = new JLabel(czasReakcjiTest + " ms");
					czas2.setBounds(500, z, 600, 50);
					czas2.setFont(new Font("Calibri", Font.PLAIN, 25));
					czas2.setForeground(Color.WHITE);
					czas2.setHorizontalAlignment(SwingConstants.CENTER);
					
					panelWynikiZlozony.add(czas2);
													
					light2.setIcon(lights);
					
					if (counterZ == 10)
					{
						
						setContentPane(panelWynikiZlozony);
						panelWynikiZlozony.revalidate();
						panelWynikiZlozony.repaint();
						
					} else
					{
					
						int czas = (2 + new Random().nextInt(2))*1000;
						myTimer.schedule(new TimerSygnal(), czas);
					
					}
					
				} else if (TimerSygnal.numerSygnalu == 2 && SwingUtilities.isMiddleMouseButton(e) && e.getClickCount() == 1)
				{
					
					long czasKlikniecia = System.nanoTime();
					long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
					int czasReakcji = (int) (czasR*0.000001);
					czasReakcjiTest = Integer.toString(czasReakcji);
					wynikTestuZlozonego1.setText(czasReakcjiTest + " ms");
					
					sr[j] = czasReakcji;
					
					counterZ++;
					
					if (counterZ == 10)
					{
					
						int sum = IntStream.of(sr).sum();
						int sredniaLiczba = sum/10;
						String sredniaTekst = Integer.toString(sredniaLiczba);
						sredniaz1.setText(sredniaTekst + " ms");
					
					}
					
					j++;
					z+=50;
					
					JLabel czas2 = new JLabel(czasReakcjiTest + " ms");
					czas2.setBounds(500, z, 600, 50);
					czas2.setFont(new Font("Calibri", Font.PLAIN, 25));
					czas2.setForeground(Color.WHITE);
					czas2.setHorizontalAlignment(SwingConstants.CENTER);
					
					panelWynikiZlozony.add(czas2);
													
					light2.setIcon(lights);
					
					if (counterZ == 10)
					{
						
						setContentPane(panelWynikiZlozony);
						panelWynikiZlozony.revalidate();
						panelWynikiZlozony.repaint();
						
					} else
					{
					
						int czas = (2 + new Random().nextInt(2))*1000;
						myTimer.schedule(new TimerSygnal(), czas);
					
					}
					
				}  else if (TimerSygnal.numerSygnalu == 1 && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 1 && SwingUtilities.isMiddleMouseButton(e) && e.getClickCount() ==1)
				{} else if (TimerSygnal.numerSygnalu == 2 && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 2 && SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 3 && SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 3 && SwingUtilities.isMiddleMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 4 && SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 4 && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 4 && SwingUtilities.isMiddleMouseButton(e) && e.getClickCount() == 1)
				{}
				
			}
			
			public void mousePressed(MouseEvent e) {				
            }
			
			public void mouseReleased(MouseEvent e) {
            }
			
			public void mouseEntered(MouseEvent e) {
            }
			
			public void mouseExited(MouseEvent e) {
            }
			
		});
		
		Action dzwiek = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		        
		    	isSpacePressed = true;
		    	
		    	if (TimerSygnal.numerSygnalu == 4 && isSpacePressed == true)
		    	{
		    		
		    		long czasKlikniecia = System.nanoTime();
					long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
					int czasReakcji = (int) (czasR*0.000001);
					czasReakcjiTest = Integer.toString(czasReakcji);
					wynikTestuZlozonego1.setText(czasReakcjiTest + " ms");
					
					sr[j] = czasReakcji;
					
					counterZ++;
					
					if (counterZ == 10)
					{
					
						int sum = IntStream.of(sr).sum();
						int sredniaLiczba = sum/10;
						String sredniaTekst = Integer.toString(sredniaLiczba);
						sredniaz1.setText(sredniaTekst + " ms");
					
					}
					
					j++;
					z+=50;
					
					JLabel czas2 = new JLabel(czasReakcjiTest + " ms");
					czas2.setBounds(500, z, 600, 50);
					czas2.setFont(new Font("Calibri", Font.PLAIN, 25));
					czas2.setForeground(Color.WHITE);
					czas2.setHorizontalAlignment(SwingConstants.CENTER);
					
					panelWynikiZlozony.add(czas2);
													
					light2.setIcon(lights);
					
					if (counterZ == 10)
					{
						
						setContentPane(panelWynikiZlozony);
						panelWynikiZlozony.revalidate();
						panelWynikiZlozony.repaint();
						
					} else
					{
					
						int czas = (2 + new Random().nextInt(2))*1000;
						myTimer.schedule(new TimerSygnal(), czas);
						
					}
							    		
		    	}
		    	
		    	isSpacePressed = false;
		    	
		    }
		};
		
		stop2.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "dzwiek");
		stop2.getActionMap().put("dzwiek", dzwiek);
		
		/**
		 * Tworzenie akcji dla przycisku stop próby z³o¿onej.
		 */
		
		stop4.addMouseListener(new MouseListener()
		{
			
			public void mouseClicked(MouseEvent e)
			{
				
				if (TimerSygnal.numerSygnalu == 1 && SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1)
				{
					
					long czasKlikniecia = System.nanoTime();
					long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
					int czasReakcji = (int) (czasR*0.000001);
					czasReakcjiProba = Integer.toString(czasReakcji);
					wynikTestuZlozonego.setText(czasReakcjiProba + " ms");
				
					light4.setIcon(lights);
				
					int czas = (2 + new Random().nextInt(2))*1000;
					myTimer.schedule(new TimerSygnal(), czas);
					
				} else if (TimerSygnal.numerSygnalu == 2 && SwingUtilities.isMiddleMouseButton(e) && e.getClickCount() == 1)
				{
					
					long czasKlikniecia = System.nanoTime();
					long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
					int czasReakcji = (int) (czasR*0.000001);
					czasReakcjiProba = Integer.toString(czasReakcji);
					wynikTestuZlozonego.setText(czasReakcjiProba + " ms");
				
					light4.setIcon(lights);
				
					int czas = (2 + new Random().nextInt(2))*1000;
					myTimer.schedule(new TimerSygnal(), czas);
					
				} else if (TimerSygnal.numerSygnalu == 3 && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1)
				{
					
					long czasKlikniecia = System.nanoTime();
					long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
					int czasReakcji = (int) (czasR*0.000001);
					czasReakcjiProba = Integer.toString(czasReakcji);
					wynikTestuZlozonego.setText(czasReakcjiProba + " ms");
				
					light4.setIcon(lights);
				
					int czas = (2 + new Random().nextInt(2))*1000;
					myTimer.schedule(new TimerSygnal(), czas);
					
				} else if (TimerSygnal.numerSygnalu == 1 && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 1 && SwingUtilities.isMiddleMouseButton(e) && e.getClickCount() ==1)
				{} else if (TimerSygnal.numerSygnalu == 2 && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 2 && SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 3 && SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 3 && SwingUtilities.isMiddleMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 4 && SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 4 && SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1)
				{} else if (TimerSygnal.numerSygnalu == 4 && SwingUtilities.isMiddleMouseButton(e) && e.getClickCount() == 1)
				{}
				
			}
			
			public void mousePressed(MouseEvent e) {				
            }
			
			public void mouseReleased(MouseEvent e) {
            }
			
			public void mouseEntered(MouseEvent e) {
            }
			
			public void mouseExited(MouseEvent e) {
            }
			
		});
		
		Action dzwiekP = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		        
		    	isSpacePressed = true;
		    	
		    	if (TimerSygnal.numerSygnalu == 4 && isSpacePressed == true)
		    	{
		    		
		    		long czasKlikniecia = System.nanoTime();
					long czasR = czasKlikniecia-TimerSygnal.czasPojawienia;
					int czasReakcji = (int) (czasR*0.000001);
					czasReakcjiProba = Integer.toString(czasReakcji);
					wynikTestuZlozonego.setText(czasReakcjiProba + " ms");
				
					light4.setIcon(lights);
				
					int czas = (2 + new Random().nextInt(2))*1000;
					myTimer.schedule(new TimerSygnal(), czas);
					
		    	}
		    	
		    	isSpacePressed = false;
		    	
		    }
		};
		
		stop4.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "dzwiekP");
		stop4.getActionMap().put("dzwiekP", dzwiekP);
		
		/**
		 * Tworzenie akcji dla przycisku wyjœcie do menu g³ównego dla testu prostego.
		 */
		
		wyjscieP.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				setContentPane(panelGlowny);
				panelGlowny.revalidate();
				panelGlowny.repaint();
				
			}
			
		});
		
		/**
		 * Tworzenie akcji dla przycisku wyjœcie do menu g³ównego dla testu z³o¿onego.
		 */
		
		wyjscieZ.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				setContentPane(panelGlowny);
				panelGlowny.revalidate();
				panelGlowny.repaint();
				
			}
			
		});
		
	}
	
	/**
	 * Metoda g³ówna.
	 */

	public static void main(String[] args) 
	{
			
		EventQueue.invokeLater(new Runnable() 
		{
			
			public void run() 
			{
				
				try 
				{
					
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					frame.setResizable(false);
					
				} catch (Exception e) 
				{
					
					e.printStackTrace();
					
				}
				
			}
			
		});
		
	}

}