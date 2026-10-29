
const permute = function (items, perms) {

    if (items.length === 0) {
        return perms;
    } else {
        let newItems = [];
        let newPerms = [];
        for (let i = 0; i < items.length; i++) {
            newItems = items;
            newPerms = perms;

            newItems.unshift(newPerms, newItems.splice(i, 1));

            permute(newItems, newPerms);
        }
    }
}

console.log(permute(['red', 'yellow', 'blue','green'], []))