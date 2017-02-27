package util;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by Mohammad on 9/30/2016.
 */
public class HierarchyTreeModel extends DefaultMutableTreeNode {

    private boolean leaf;

    public HierarchyTreeModel(Object userObject) {
        super(userObject);
    }

    @Override
    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
