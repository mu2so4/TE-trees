# Преобразование внутреннего хранения дерева
Данная программа реализует решение задачи по преобразованию представления
ориентированного леса `Collection<TreeEntity>`, в котором каждый узел
`TreeEntity` хранит `id` своего прямого родителя, в такое представление орлеса
`Collection<TreeDTO>`, в котором каждый узел хранит список своих прямых
дочерних узлов `TreeDTO`.

Данное задание выполнено в рамках собеседований на должность стажёра
Java-разработчика в True Engineering с 9 по 18 августа 2023 года.

## Описание алгоритма
Алгоритм работает при любом порядке узлов `TreeEntity`, включая те ситуации, когда
дочерний узел подаётся до своего прямого родителя.

Заводится отображение `dtosById` такое, чтобы мы могли по `id` быстро переместиться в узел
`TreeDTO` с таким `id`. Итоговое решение будет представлять список корневых узлов
`TreeDTO` `result`.

Для каждого узла `node` из `Collection<TreeEntity>` проводятся следующие операции:
1. Если `node` ранее не был добавлен в `dtosById`, он создаётся с нуля и добавляется
в `dtosById`, иначе к уже добавленному узлу только дописывается его `name`;
2. Если `node` является корневым, он добавляется в `result`. В противном случае, мы
пробуем отыскать его прямого потомка `parent` в `dtosById`. Если его нет, то мы  его создаём
с нуля и кладём в отображение. Далее, независимо от того, был ли там `parent` изначально, мы
в список его дочерних узлов добавляем `node`.

После прохода по всем узлам возвращаем `result`.

## Определение равенства деревьев `TreeDTO`
Два узла `TreeDTO` равны тогда и только тогда, когда
1. У них одинаковый `id`
2. У них одинаковое имя `name`
3. У них одинаковое количество прямых дочерних узлов, возможно, нулевое
4. Между списками "детей" узлов можно построить такое взаимно-однозначное отображение,
чтобы каждый дочерний узел первого узла отображался в равный ему дочерний узел второго, и наоборот
5. При проверке равенства узлов не имеет значения порядок их дочерних узлов