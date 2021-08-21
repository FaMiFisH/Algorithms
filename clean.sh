#/bin/bash

# removes all .class files
for dir in */; do
    cd $dir
    for file in *; do 
        if [ "${file: -6}" == ".class" ] 
        then
            rm $file
            echo "Removed $file"
        fi
    done
    cd ..
done