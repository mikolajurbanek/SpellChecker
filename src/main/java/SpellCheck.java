import java.io.*;

public class
SpellCheck {

    public SpellCheck() {
    }

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            showUsageMessage();
        } else {
            String lastArg = args[args.length - 1];
            String path = "src/wordlist.txt";
            Object object = new LousyStringHasher();
            PrintStream printStream = System.out;
            boolean isQuiet = false;
            String wordToCheck = "example";

            for(int i = 0; i < args.length - 1; ++i) {
                switch (args[i]) {
                    case "-degenerate" -> object = new DegenerateStringHasher();
                    case "-lousy" -> object = new LousyStringHasher();
                    case "-better" -> object = new BetterStringHasher();
                    case "-quiet" -> {
                        printStream = new PrintStream(new NullOutputStream());
                        isQuiet = true;
                    }
                    case "-wordlist" -> {
                        ++i;
                        if (i > args.length - 1) {
                            showUsageMessage();
                            return;
                        }
                        path = "src/" + args[i];
                    }
                    case "word:" -> {
                        ++i;
                        if (i > args.length - 1) {
                            showUsageMessage();
                            return;
                        }
                        wordToCheck = args[i].toUpperCase();
                    }
                }
            }

            if (lastArg.charAt(0) == '-') {
                showUsageMessage();
            } else {
                try {
                    long time1 = System.currentTimeMillis();
                    (new Checker()).check(wordToCheck, path, (StringHasher)object, printStream);
                    long time2 = System.currentTimeMillis();
                    if (isQuiet) {
                        System.out.println("Checker ran in " + (time2 - time1) + "ms");
                    }
                } catch (IOException var11) {
                    var11.printStackTrace();
                }
            }
        }
    }

    private static void showUsageMessage() {
        System.out.println("Usage: java SpellCheck [options] inputFilename");
        System.out.println();
        System.out.println("    options");
        System.out.println("    -------");
        System.out.println("    -degenerate");
        System.out.println("        runs the spell checker with the degenerate word hashing algorithm");
        System.out.println();
        System.out.println("    -lousy");
        System.out.println("        runs the spell checker with a lousy word hashing algorithm (default)");
        System.out.println();
        System.out.println("    -better");
        System.out.println("        runs the spell checker with a better word hashing algorithm");
        System.out.println();
        System.out.println("    -quiet");
        System.out.println("        runs the spell checker without any output, reporting the total time");
        System.out.println("        taken to load the dictionary and perform the spell check");
        System.out.println();
        System.out.println("    -wordlist wordlistFilename");
        System.out.println("        runs the spell checker using the wordlist specified, rather than");
        System.out.println("        the default (wordlist.txt)");
        System.out.println();
        System.out.println("    example");
        System.out.println("    -------");
        System.out.println("    java SpellCheck -wordlist biglist.txt -better -quiet big-input.txt");
        System.out.println("        executes the spell checker using the wordlist 'biglist.txt', the");
        System.out.println("        better word hashing algorithm, in quiet mode (i.e. no output),");
        System.out.println("        on the input file 'big-input.txt'");
    }
}
