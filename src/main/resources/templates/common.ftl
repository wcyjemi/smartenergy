<link rel="stylesheet" href="/statics/css/bootstrap.min.css" media="all">
<script src="/statics/plugins/bootstrap-treeview/js/bootstrap-treeview.js"></script>

<div class="layui-col-sm2">
    <div class="layui-card">
        <div class="layui-card-body">
            <div id="treeview-checkable" class=""></div>
        </div>
    </div>
</div>

<script>
    $(function () {
        var defaultData = [
            {
                text: 'Parent 1',
                href: '#parent1',
                tags: ['4'],
                nodes: [
                    {
                        text: 'Child 1',
                        href: '#child1',
                        tags: ['2'],
                        nodes: [
                            {
                                text: 'Grandchild 1',
                                href: '#grandchild1',
                                tags: ['0']
                            },
                            {
                                text: 'Grandchild 2',
                                href: '#grandchild2',
                                tags: ['0']
                            }
                        ]
                    },
                    {
                        text: 'Child 2',
                        href: '#child2',
                        tags: ['0']
                    }
                ]
            },
            {
                text: 'Parent 2',
                href: '#parent2',
                tags: ['0']
            },
            {
                text: 'Parent 3',
                href: '#parent3',
                tags: ['0']
            },
            {
                text: 'Parent 4',
                href: '#parent4',
                tags: ['0']
            },
            {
                text: 'Parent 5',
                href: '#parent5'  ,
                tags: ['0']
            }
        ];

        $('#treeview-checkable').treeview({
            data: defaultData,
            showIcon: true,
            showCheckbox: true,
            onNodeChecked: function(event, node) {
                Msg.info(node.text);
            },
            onNodeUnchecked: function (event, node) {
                Msg.info(node.text);
            }
        });
    })

</script>