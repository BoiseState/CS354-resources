//partial code snippet from CS321 P4.
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

        ...
        
        traverse(diskRead(x.children[i]), action);
        action.act(x.keys[i]);

        ...
    }
