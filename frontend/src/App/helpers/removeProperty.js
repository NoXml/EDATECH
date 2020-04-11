const removeProperty = (object, property) => {
    const {[property]: propertyToRemove, ...newObject} = object;
    return newObject;
};

export default removeProperty;