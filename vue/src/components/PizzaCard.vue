<template>
    <div class="pizza-card">
        <h3 class="pizza-name">The Jackson</h3>
        <p class="pizza-desc">The pizza description</p>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
@font-face {
    font-family: 'Mandalore Laser Title';
    src: url('./fonts/MandaloreLaserTitle.woff2') format('woff2'),
        url('./fonts/MandaloreLaserTitle.woff') format('woff');
    font-weight: normal;
    font-style: normal;
    font-display: swap;
}

:root{
    --brand-green-color: #5FA873;
    --brand-brown-color: #A18F63;
    --brand-lightred-color: #AC685B;
    --brand-darkred-color: #BB554A;
    --brand-white-color: #FFFFFF;
}


*{
    font-family: 'Mandalore Laser Title';

}
.pizza-card>p{
    align-self: flex-end;
    font-size: 0em;
    transition: 500ms;
}
.pizza-card{
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    margin: 10px;
    border-radius: 15px;
    width: 300px;
    height: 150px;
    background-image: url('../images/pizza.png');
    
    transition: 500ms;
    padding: 5px;

}
.pizza-card:hover,
.pizza-card:active{
    width: 350px;
    height: 350px;
    transition: 500ms;

}
.pizza-card:hover>p,
.pizza-card:active>p{
    transition: 500ms;
    font-size: 1em;

}
.pizza-card:hover>h3,
.pizza-card:active>h3{
    transition: 500ms;
    font-size: 1.5em;
}
.pizza-card>h3,
.pizza-card>h3{
    transition: 500ms;
    font-size: 1.2em;
}
.pizza-name,
.pizza-desc{
    color: white;
    text-shadow: black 2px 0 10px;
}
</style>