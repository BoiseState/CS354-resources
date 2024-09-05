//partial code snippet from CS321 P4.

public class Action {


    private interface Action {
        void act(TreeObject obj);
    }

    public long[] getSortedKeyArray() throws IOException {

        ...

        traverse(root, (TreeObject obj) -> {
            array.add(obj.getKey());
        });

        ...
    }

    @Override
    public void dumpToFile(PrintWriter out) throws IOException {

        traverse(root, (TreeObject obj) -> {
            out.printf("%s %d\n", obj.getKey(), obj.getCount());
        });
    }

    private void traverse(Node x, Action action) throws IOException {

        if (x == null) {
            return;
        }
        for (int i = 0; i < x.n; i++) {
            traverse(diskRead(x.children[i]), action);
            action.act(x.keys[i]);
        }
        traverse(diskRead(x.children[x.n]), action);
    }

}