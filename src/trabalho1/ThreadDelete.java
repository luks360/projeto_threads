package trabalho1;

import java.io.File;

public class ThreadDelete extends Thread {

    ThreadDelete(int prioridade) {
        setPriority(prioridade);
    }

    public void run() {

        while (true) {
            String path = "Pasta2";
            String pesquisar = ".txt";
            File caminho = new File(path);
            String nomeArq = null;
            boolean caminhoValido = caminho.exists();
            boolean eDiretorio = caminho.isDirectory();
            if (caminhoValido && eDiretorio) {
                String[] conteudo = caminho.list();
                for (String arquivo : conteudo) {
                    if (arquivo.contains(pesquisar)) {
                        nomeArq = arquivo;
                    }
                }
            }
            File fileDelete = new File(path + "/" + nomeArq);
            boolean Deleted = fileDelete.delete();
            while (!Deleted) {
                fileDelete.delete();

                if (!fileDelete.exists())
                    break;

            }

            try {
                ThreadDelete.sleep(5000);
            } catch (InterruptedException e) {

            }
        }
    }
}
