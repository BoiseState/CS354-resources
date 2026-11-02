// a permutation lister. Credit Higher Order Perl, by MJD

const permute = function (items, perms) {

    if (items.length === 0) {
        console.log(...perms);
    } else {
        let newItems = [];
        let newPerms = [];
        for (let i = 0; i < items.length; i++) {
            newItems = [...items];
            newPerms = [...perms];

            newPerms.unshift( ...newItems.splice(i, 1));

            permute(newItems, newPerms);
        }
    }
}

permute(['red', 'yellow', 'blue','green'], []);